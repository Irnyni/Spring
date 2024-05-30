package com.post.post.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.post.post.Repository.PostagemRepository;
import com.post.post.entity.Postagem;

@Service
public class PostagemService {
        private  final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    public  List<Postagem> listar(){

       return postagemRepository.findAll();

    }

    public  Postagem criarPost(Postagem postagem) {
         return postagemRepository.save(postagem);

    }

    public Optional<Postagem> obterPostagemPorId(Long id) {
          return postagemRepository.findById(id);
    }

    public Postagem atualizarPostagem(Postagem postagem) {
        return postagemRepository.save(postagem);
    }

    public  void delete(Long id) {
        postagemRepository.deleteById(id);
    }


}