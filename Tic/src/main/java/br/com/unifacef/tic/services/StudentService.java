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

import br.com.unifacef.tic.repositories.StudentRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Student;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Student> findAllPaged(Pageable pageable){
		Page<Student> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Student findById(Integer id){
		Optional<Student> obj = repository.findById(id);
		Student entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Student insert(Student dto) {
		Student entity = new Student();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Student update(Student dto) {
		try {
			Student entity = repository.save(dto);
			return entity;
		} catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + dto.getCode());
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
