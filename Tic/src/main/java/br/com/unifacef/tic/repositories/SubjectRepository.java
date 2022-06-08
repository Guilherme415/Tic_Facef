package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacef.tic.models.Student;
import br.com.unifacef.tic.models.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
