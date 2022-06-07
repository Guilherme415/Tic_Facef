package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Student;

public interface SubjectRepository extends JpaRepository<Student, Integer> {

}
