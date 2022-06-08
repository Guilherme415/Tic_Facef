package br.com.unifacef.tic.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.unifacef.tic.models.Student;

import br.com.unifacef.tic.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public ResponseEntity<Page<Student>> findAll(Pageable pageable){
		Page<Student> list = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{code}")
	public ResponseEntity<Student> findById(@PathVariable Integer code){
		Student obj = service.findById(code);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Student> insert(@RequestBody Student dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{code}")
				.buildAndExpand(dto.getCode())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping
	public ResponseEntity<Student> update(@RequestBody Student dto){
		dto = service.update(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "{code}")
	public ResponseEntity<Void> delete(@PathVariable Integer code){
		service.delete(code);
		return ResponseEntity.noContent().build();
	}
}
