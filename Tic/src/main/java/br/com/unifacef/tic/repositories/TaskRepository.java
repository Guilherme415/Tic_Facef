package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

}
