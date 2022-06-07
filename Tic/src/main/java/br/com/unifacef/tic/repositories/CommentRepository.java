package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.unifacef.tic.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
