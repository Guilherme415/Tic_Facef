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

import br.com.unifacef.tic.repositories.CommentRepository;
import br.com.unifacef.tic.services.exceptions.DatabaseException;
import br.com.unifacef.tic.services.exceptions.ResourceNotFoundException;
import br.com.unifacef.tic.models.Comment;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;
		
	@Transactional(readOnly = true)
	public Page<Comment> findAllPaged(Pageable pageable){
		Page<Comment> list = repository.findAll(pageable);
		return list;
	}
	
	@Transactional(readOnly = true)
	public Comment findById(Integer id){
		Optional<Comment> obj = repository.findById(id);
		Comment entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return entity;
	}
	
	@Transactional
	public Comment insert(Comment dto) {
		Comment entity = new Comment();
		entity = repository.save(dto);
		
		return entity;
	}

	@Transactional
	public Comment update(Comment dto) {
		try {
			Comment entity = repository.save(dto);
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
