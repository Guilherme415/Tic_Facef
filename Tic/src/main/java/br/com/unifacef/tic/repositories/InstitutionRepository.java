package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Institution;

public interface InstitutionRepository extends JpaRepository<Institution, Integer> {

}
