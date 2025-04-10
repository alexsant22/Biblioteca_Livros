package com.example.Biblioteca_Livros.Service;

import com.example.Biblioteca_Livros.DTO.ClienteDTO;
import com.example.Biblioteca_Livros.Entity.Cliente;
import com.example.Biblioteca_Livros.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    // Cliente para ClienteDTO
    public ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setIdCliente(cliente.getIdCliente());
        clienteDTO.setNomeCliente(cliente.getNomeCliente());
        clienteDTO.setSobrenomeCliente(cliente.getSobrenomeCliente());
        clienteDTO.setCpf(cliente.getCpf());

        return clienteDTO;
    }

    // ClienteDTO para Cliente
    public Cliente fromDTO(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setSobrenomeCliente(clienteDTO.getSobrenomeCliente());
        cliente.setCpf(clienteDTO.getCpf());

        return cliente;
    }

    // Buscar todos
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<ClienteDTO> getById(Long id) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            return Optional.of(this.toDTO(optionalCliente.get()));
        } else {
            return Optional.empty();
        }
    }

    // Create / Save
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = this.fromDTO(clienteDTO);
        Cliente clienteBd = repository.save(cliente);

        return this.toDTO(clienteBd);
    }

    // Update
    public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            cliente.setNomeCliente(clienteDTO.getNomeCliente());
            cliente.setSobrenomeCliente(clienteDTO.getSobrenomeCliente());

            Cliente clienteAtt = repository.save(cliente);

            return Optional.of(this.toDTO(clienteAtt));
        } else {
            return Optional.empty();
        }
    }

    // Delete
    public boolean delete (Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
