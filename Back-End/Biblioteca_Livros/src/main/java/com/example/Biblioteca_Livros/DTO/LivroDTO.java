package com.example.Biblioteca_Livros.DTO;

import com.example.Biblioteca_Livros.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO implements Serializable {
    private Long idLivro;
    private String nomeLivro;
    private String autor;
    private int ISBN;
    private String genero;

    // Transfomações do DTO e Entity
    public Livro toLivro() {
        return new Livro(
                this.idLivro,
                this.nomeLivro,
                this.autor,
                this.ISBN,
                this.genero
        );
    }

    public LivroDTO fromLivro(Livro livro) {
        return new LivroDTO(
                livro.getIdLivro(),
                livro.getNomeLivro(),
                livro.getAutor(),
                livro.getISBN(),
                livro.getGenero()
        );
    }
}