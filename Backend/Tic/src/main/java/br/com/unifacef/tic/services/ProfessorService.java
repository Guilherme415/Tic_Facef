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

import br.com.unifacef.tic.repositories.ProfessorRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Professor;

@Service
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Professor> findAllPaged(Pageable pageable){
		Page<Professor> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Professor findById(Integer codig){
		Optional<Professor> obj = repository.findById(codig);
		Professor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Professor insert(Professor dto) {
		Professor entity = new Professor();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Professor update(Professor dto) {
		try {
			Professor entity = repository.save(dto);
			return entity;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Codig not found " + dto.getCode());
		}
	}

	public void delete(Integer codig) {
		try {
			repository.deleteById(codig);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + codig);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
