package com.post.post.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.post.post.entity.Postagem;
import com.post.post.service.PostagemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/postagens")
public class PostagemController {
    private final PostagemService postagemService;

    public PostagemController(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    @GetMapping
    public List<Postagem> listarPostagens() {
       return postagemService.listar();
    }

    @GetMapping("/{id}") // Corrigido para obter uma postagem por ID
    public ResponseEntity<Postagem> getPostagemById(@PathVariable Long id) {
        Optional<Postagem> postagemOptional = postagemService.obterPostagemPorId(id);
        if (postagemOptional.isPresent()) {
            return ResponseEntity.ok(postagemOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Postagem criarPostagem(@RequestBody Postagem postagem) {
        return postagemService.atualizarPostagem(postagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizarPostagem(@PathVariable Long id, @RequestBody Postagem postagemAtualizada) {
        Optional<Postagem> postagemOptional = postagemService.obterPostagemPorId(id);
        if (postagemOptional.isPresent()) {
            Postagem postagemExistente = postagemOptional.get();
            postagemExistente.setDescricao(postagemAtualizada.getDescricao());
            postagemExistente.setPost(postagemAtualizada.getPost());
            postagemExistente.setImagem(postagemAtualizada.getImagem());
            Postagem postagemAtualizadaSalva = postagemService.atualizarPostagem(postagemExistente);
            return ResponseEntity.ok(postagemAtualizadaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
