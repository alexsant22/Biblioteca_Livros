package com.example.Biblioteca_Livros.Controller;

import com.example.Biblioteca_Livros.DTO.LivroDTO;
import com.example.Biblioteca_Livros.Entity.Livro;
import com.example.Biblioteca_Livros.Service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/buscar")
    public List<Livro> getAll() {
        return service.getAll();
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<LivroDTO> getById(@PathVariable Long id) {
        Optional<LivroDTO> optionalLivroDTO = service.getById(id);

        if (optionalLivroDTO.isPresent()) {
            return ResponseEntity.ok(optionalLivroDTO.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> create(@RequestBody LivroDTO livroDTO) {
        LivroDTO savedLivroDTO = service.create(livroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLivroDTO);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<LivroDTO> update(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        Optional<LivroDTO> optionalLivroDTO = service.updateLivro(id, livroDTO);

        if (optionalLivroDTO.isPresent()) {
            return ResponseEntity.ok(optionalLivroDTO.get());
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