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

import br.com.unifacef.tic.models.Institution;

import br.com.unifacef.tic.services.InstitutionService;

@RestController
@RequestMapping(value = "/institutions")
public class InstitutionController {
	
	@Autowired
	private InstitutionService service;
	
	@GetMapping
	public ResponseEntity<Page<Institution>> findAll(Pageable pageable){
		Page<Institution> list = service.findAllPaged(pageable);
		
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{cnpj}")
	public ResponseEntity<Institution> findById(@PathVariable Integer cnpj){
		Institution obj = service.findById(cnpj);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Institution> insert(@RequestBody Institution dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{cnpj}")
				.buildAndExpand(dto.getCNPJ())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping
	public ResponseEntity<Institution> update(@RequestBody Institution dto){
		dto = service.update(dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "{cnpj}")
	public ResponseEntity<Void> delete(@PathVariable Integer cnpj){
		service.delete(cnpj);
		return ResponseEntity.noContent().build();
	}
}
