package com.example.Biblioteca_Livros.Repository;

import com.example.Biblioteca_Livros.Entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
