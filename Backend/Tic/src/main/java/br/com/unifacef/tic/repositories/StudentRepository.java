package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacef.tic.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
