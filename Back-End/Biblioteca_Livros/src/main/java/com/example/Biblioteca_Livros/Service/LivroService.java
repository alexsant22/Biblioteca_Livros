package com.example.Biblioteca_Livros.Service;

import com.example.Biblioteca_Livros.DTO.LivroDTO;
import com.example.Biblioteca_Livros.Entity.Livro;
import com.example.Biblioteca_Livros.Repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    // Buscar todos
    public List<Livro> getAll() {
        return repository.findAll();
    }

    // Buscar por ID
    public Optional<LivroDTO> getById(Long id) {
        Optional<Livro> optionalLivro = repository.findById(id);

        if (optionalLivro.isPresent()) {
            LivroDTO produtoDTO = new LivroDTO();
            return Optional.of(produtoDTO.fromLivro(optionalLivro.get()));
        } else {
            return Optional.empty();
        }
    }

    // Create / save
    public LivroDTO create(LivroDTO livroDTO) {
        Livro livro = livroDTO.toLivro();
        livro = repository.save(livro);

        return livroDTO.fromLivro(livro);
    }

    public Optional<LivroDTO> updateLivro(Long id, LivroDTO livroDTO) {
        Optional<Livro> optionalLivro = repository.findById(id);

        if (optionalLivro.isPresent()) {
            Livro livro = optionalLivro.get();

            livro.setNomeLivro(livroDTO.getNomeLivro());
            livro.setAutor(livroDTO.getAutor());
            livro.setGenero(livroDTO.getGenero());
            livro.setISBN(livroDTO.getISBN());

            livro = repository.save(livro);

            return Optional.of(livroDTO.fromLivro(livro));
        } else {
            return Optional.empty();
        }
    }

    // Delete
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);

            return true;
        } else {
            return false;
        }
    }
}
