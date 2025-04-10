package com.example.Biblioteca_Livros.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String cpf;
}
