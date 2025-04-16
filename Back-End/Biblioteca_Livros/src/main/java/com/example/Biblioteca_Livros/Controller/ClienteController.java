package com.example.Biblioteca_Livros.Controller;

import com.example.Biblioteca_Livros.DTO.ClienteDTO;
import com.example.Biblioteca_Livros.Entity.Cliente;
import com.example.Biblioteca_Livros.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/buscar")
    public List<Cliente> getAll() {
        return service.getAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<ClienteDTO> getById(@PathVariable Long id) {
        Optional<ClienteDTO> optionalClienteDTO = service.getById(id);

        if (optionalClienteDTO.isPresent()) {
            return ResponseEntity.ok(optionalClienteDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO saveClienteDTO = service.create(clienteDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(saveClienteDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClienteDTO> update(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        Optional<ClienteDTO> optionalClienteDTO = service.updateCliente(id, clienteDTO);

        if (optionalClienteDTO.isPresent()) {
            return ResponseEntity.ok(optionalClienteDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
