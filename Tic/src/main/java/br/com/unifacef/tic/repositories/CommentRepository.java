package br.com.unifacef.tic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.unifacef.tic.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
