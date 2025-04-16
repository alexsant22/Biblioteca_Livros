package com.example.Biblioteca_Livros.DTO;

import com.example.Biblioteca_Livros.Entity.Cliente;
import com.example.Biblioteca_Livros.Entity.Emprestimo;
import com.example.Biblioteca_Livros.Entity.Livro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoDTO implements Serializable {
    private Long idEmprestimo;
    private Date data_inicial;
    private Date data_final;
    private Cliente cliente;
    private Set<Livro> livros;

    // Transfomações do DTO e Entity
    public Emprestimo toEmprestimo() {
        return new Emprestimo(
                this.idEmprestimo,
                this.data_inicial,
                this.data_final,
                this.getCliente(),
                this.livros
        );
    }

    public EmprestimoDTO fromEmprestimo(Emprestimo emprestimo) {
        return new EmprestimoDTO(
                emprestimo.getIdEmprestimo(),
                emprestimo.getData_inicial(),
                emprestimo.getData_final(),
                emprestimo.getCliente(),
                emprestimo.getLivros()
        );
    }
}
