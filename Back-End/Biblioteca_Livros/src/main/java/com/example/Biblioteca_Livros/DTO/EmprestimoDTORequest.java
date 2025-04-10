package com.example.Biblioteca_Livros.DTO;

import com.example.Biblioteca_Livros.Entity.Cliente;
import com.example.Biblioteca_Livros.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTORequest {
    private Cliente cliente;
    private Date data_inicial;
    private Date data_final;
    private List<Livro> livroList;
}
