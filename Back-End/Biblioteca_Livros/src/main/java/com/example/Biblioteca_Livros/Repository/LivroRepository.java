package com.example.Biblioteca_Livros.Repository;

import com.example.Biblioteca_Livros.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
