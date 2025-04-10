package com.example.Biblioteca_Livros.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    private Long idLivro;
    private String nomeLivro;
    private String autor;
    private String isbn;
    private String genero;
}