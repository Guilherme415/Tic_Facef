package br.com.unifacef.tic.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import br.com.unifacef.tic.repositories.ClassRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Class;

public class ClassService {
	
	@Autowired
	private ClassRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Class> findAllPaged(Pageable pageable){
		Page<Class> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Class findById(Integer id){
		Optional<Class> obj = repository.findById(id);
		Class entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Class insert(Class dto) {
		Class entity = new Class();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Class update(Class dto) {
		try {
			Class entity = repository.save(dto);
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
