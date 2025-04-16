package com.example.Biblioteca_Livros.DTO;

import com.example.Biblioteca_Livros.Entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO implements Serializable {
    private Long idCliente;
    private String nomeCliente;
    private String sobrenomeCliente;
    private String cpf;

    // Transfomações do DTO e Entity
    public Cliente toCliente() {
        return new Cliente(
                this.idCliente,
                this.nomeCliente,
                this.sobrenomeCliente,
                this.cpf
        );
    }

    public ClienteDTO fromClienteDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getIdCliente(),
                cliente.getNomeCliente(),
                cliente.getSobrenomeCliente(),
                cliente.getCpf()
        );
    }
}
