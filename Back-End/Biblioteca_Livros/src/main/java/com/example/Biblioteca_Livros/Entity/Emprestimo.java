package com.example.Biblioteca_Livros.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;
    private Date data_inicial;
    private Date data_final;

        // Relacionamento entre entidades
    // Relacionamento com Cliente
    @OneToOne() // 1 --- 1
    @JoinColumn(name = "idCliente", referencedColumnName = "idCliente")
    private Cliente cliente;

    // Relacionamento com Livro
    @OneToMany(mappedBy = "emprestimo", cascade = CascadeType.ALL) // 1 --- N
    @JsonManagedReference
    private List<Livro> livroList;
}
