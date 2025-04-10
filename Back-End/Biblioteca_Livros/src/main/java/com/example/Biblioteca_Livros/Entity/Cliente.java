package com.example.Biblioteca_Livros.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;

    @Column(unique = true) // Faz esse atributo ser unico na tabela
    private String cpf;

    // Relacionamento entre entidades
    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private Emprestimo emprestimo;
}
