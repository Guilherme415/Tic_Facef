package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepository extends JpaRepository<br.com.unifacef.tic.models.Class, Integer> {

}
