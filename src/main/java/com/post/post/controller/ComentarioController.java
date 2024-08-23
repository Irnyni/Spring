package com.post.post.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.post.entity.Comentario;
import com.post.post.entity.Postagem;
import com.post.post.service.ComentarioService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    private ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

@GetMapping
public List<Comentario> getAll() {
    return comentarioService.listar();
}


}
