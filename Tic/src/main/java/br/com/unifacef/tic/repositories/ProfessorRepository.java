package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
