package com.post.post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.post.post.Repository.ComentarioRepository;
import com.post.post.entity.Comentario;

@Service
public class ComentarioService {
     private ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

public List <Comentario> listar(){

    return comentarioRepository.findAll();
}

}
