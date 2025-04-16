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

    // Buscar todos
    public List<Cliente> getAll() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<ClienteDTO> getById(Long id) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            ClienteDTO produtoDTO = new ClienteDTO();
            return Optional.of(produtoDTO.fromClienteDTO(optionalCliente.get()));
        } else {
            return Optional.empty();
        }
    }

    // Create / Save
    public ClienteDTO save(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.toCliente();
        cliente = repository.save(cliente);

        return clienteDTO.fromClienteDTO(cliente);
    }

    // Update
    public Optional<ClienteDTO> updateCliente(Long id, ClienteDTO clienteDTO) {
        Optional<Cliente> optionalCliente = repository.findById(id);

        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();

            cliente.setNomeCliente(clienteDTO.getNomeCliente());
            cliente.setSobrenomeCliente(clienteDTO.getSobrenomeCliente());
            cliente.setCpf(clienteDTO.getCpf());

            cliente = repository.save(cliente);

            return Optional.of(clienteDTO.fromClienteDTO(cliente));
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
