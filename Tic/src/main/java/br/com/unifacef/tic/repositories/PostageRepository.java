package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Postage;

public interface PostageRepository extends JpaRepository<Postage, Integer> {

}
