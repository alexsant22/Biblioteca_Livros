package com.example.Biblioteca_Livros.Controller;

import com.example.Biblioteca_Livros.DTO.EmprestimoDTO;
import com.example.Biblioteca_Livros.Entity.Emprestimo;
import com.example.Biblioteca_Livros.Service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService service;

    @GetMapping("/buscar")
    public List<Emprestimo> getAll() {
        return service.getAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<EmprestimoDTO> getById(@PathVariable Long id) {
        Optional<EmprestimoDTO> optionalEmprestimoDTO = service.getById(id);

        if (optionalEmprestimoDTO.isPresent()) {
            return ResponseEntity.ok(optionalEmprestimoDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<EmprestimoDTO> create(@RequestBody EmprestimoDTO emprestimoDTO) {
        EmprestimoDTO savedEmprestimoDTO = service.create(emprestimoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmprestimoDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EmprestimoDTO> update(@PathVariable Long id, @RequestBody EmprestimoDTO emprestimoDTO) {
        Optional<EmprestimoDTO> optionalEmprestimoDTO = service.updateEmprestimo(id, emprestimoDTO);

        if (optionalEmprestimoDTO.isPresent()) {
            return ResponseEntity.ok(optionalEmprestimoDTO.get());
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