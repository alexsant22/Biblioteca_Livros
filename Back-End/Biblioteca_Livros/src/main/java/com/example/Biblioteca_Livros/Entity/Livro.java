package com.example.Biblioteca_Livros.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Livro implements Serializable {
    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;
    private String nomeLivro;
    private String autor;

    @Column(unique = true) // Faz esse atributo ser unico na tabela
    private int ISBN;

    private String genero;

    // Relacionamento de entidades
    @ManyToMany(mappedBy = "livros") // N --- N
    @JsonIgnore
    private Set<Emprestimo> emprestimo;

    public Livro(Long idLivro, String nomeLivro, String autor, int ISBN, String genero) {
        this.idLivro = idLivro;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.ISBN = ISBN;
        this.genero = genero;
    }
}
