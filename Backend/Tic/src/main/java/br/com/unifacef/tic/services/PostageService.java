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

import br.com.unifacef.tic.repositories.PostageRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Postage;

@Service
public class PostageService {
	
	@Autowired
	private PostageRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Postage> findAllPaged(Pageable pageable){
		Page<Postage> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Postage findById(Integer id){
		Optional<Postage> obj = repository.findById(id);
		Postage entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Postage insert(Postage dto) {
		Postage entity = new Postage();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Postage update(Postage dto) {
		try {
			Postage entity = repository.save(dto);
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
