package com.example.Biblioteca_Livros.Repository;

import com.example.Biblioteca_Livros.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
