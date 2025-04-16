package com.example.Biblioteca_Livros.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String isbn;

    private String genero;

    // Relacionamento de entidades
    @ManyToMany(mappedBy = "livros") // N --- N
    private Set<Emprestimo> emprestimo;
}
