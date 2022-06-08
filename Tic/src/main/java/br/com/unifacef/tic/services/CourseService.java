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

import br.com.unifacef.tic.repositories.CourseRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Course> findAllPaged(Pageable pageable){
		Page<Course> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Course findById(Integer id){
		Optional<Course> obj = repository.findById(id);
		Course entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Course insert(Course dto) {
		Course entity = new Course();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Course update(Course dto) {
		try {
			Course entity = repository.save(dto);
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
