package br.com.unifacef.tic.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.unifacef.tic.repositories.SubjectRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Subject;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Subject> findAllPaged(Pageable pageable){
		Page<Subject> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Subject findById(Integer id){
		Optional<Subject> obj = repository.findById(id);
		Subject entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Subject insert(Subject dto) {
		Subject entity = new Subject();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Subject update(Subject dto) {
		try {
			Subject entity = repository.save(dto);
			return entity;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + dto.getId());
		}
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
