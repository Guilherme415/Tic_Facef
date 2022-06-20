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

import br.com.unifacef.tic.repositories.InstitutionRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Institution;

@Service
public class InstitutionService {
	
	@Autowired
	private InstitutionRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Institution> findAllPaged(Pageable pageable){
		Page<Institution> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Institution findById(Integer cnpj){
		Optional<Institution> obj = repository.findById(cnpj);
		Institution entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Institution insert(Institution dto) {
		Institution entity = new Institution();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Institution update(Institution dto) {
		try {
			Institution entity = repository.save(dto);
			return entity;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + dto.getCNPJ());
		}
	}

	public void delete(Integer cnpj) {
		try {
			repository.deleteById(cnpj);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + cnpj);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
