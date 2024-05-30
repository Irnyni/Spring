package com.post.post.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.post.entity.Postagem;


public interface PostagemRepository extends JpaRepository<Postagem,Long> {

}
