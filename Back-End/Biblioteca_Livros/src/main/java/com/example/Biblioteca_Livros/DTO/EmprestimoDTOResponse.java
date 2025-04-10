package com.example.Biblioteca_Livros.DTO;

import com.example.Biblioteca_Livros.Entity.Cliente;
import com.example.Biblioteca_Livros.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTOResponse {
    private Long idEmprestimo;
    private String dataInicial;
    private String dataFinal;
    private Cliente cliente;
    private List<Livro> livroList;
}
