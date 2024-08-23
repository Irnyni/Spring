package com.post.post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String conteudo;

 // Muitos Comentarios para um Post
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Postagem post;
    
    public void setPost(Postagem post) {
        this.post = post;
    }
    public Postagem getPost() {
        return post;
    }
    public Comentario() {
    }
    public Comentario(Long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }


}
