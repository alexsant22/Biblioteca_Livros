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
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;

    @Column(unique = true) // Faz esse atributo ser unico na tabela
    private String cpf;

    // Relacionamento entre entidades
    @OneToMany(mappedBy = "cliente")
    @JsonBackReference
    private Set<Emprestimo> emprestimo;
    // estrutura Set tem o mesmo funcionamento do List, porém evitando a duplicidade de valores
}
