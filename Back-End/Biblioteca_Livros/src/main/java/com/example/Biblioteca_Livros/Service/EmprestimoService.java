package com.example.Biblioteca_Livros.Service;

import com.example.Biblioteca_Livros.DTO.EmprestimoDTO;
import com.example.Biblioteca_Livros.Entity.Emprestimo;
import com.example.Biblioteca_Livros.Repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository repository;

    // Buscar todos os empréstimos
    public List<Emprestimo> getAll() {
        return repository.findAll();
    }

    // Buscar empréstimo por ID
    public Optional<EmprestimoDTO> getById(Long id) {
        Optional<Emprestimo> optionalEmprestimo = repository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
            return Optional.of(emprestimoDTO.fromEmprestimo(optionalEmprestimo.get()));
        } else {
            return Optional.empty();
        }
    }

    // Criar novo empréstimo
    public EmprestimoDTO create(EmprestimoDTO emprestimoDTO) {
        Emprestimo emprestimo = emprestimoDTO.toEmprestimo();
        emprestimo = repository.save(emprestimo);

        return emprestimoDTO.fromEmprestimo(emprestimo);
    }

    // Atualizar empréstimo existente
    public Optional<EmprestimoDTO> updateEmprestimo(Long id, EmprestimoDTO emprestimoDTO) {
        Optional<Emprestimo> optionalEmprestimo = repository.findById(id);

        if (optionalEmprestimo.isPresent()) {
            Emprestimo emprestimo = optionalEmprestimo.get();

            emprestimo.setData_inicial(emprestimoDTO.getData_inicial());
            emprestimo.setData_final(emprestimoDTO.getData_final());
            emprestimo.setCliente(emprestimoDTO.getCliente());
            emprestimo.setLivros(emprestimoDTO.getLivros());

            emprestimo = repository.save(emprestimo);

            return Optional.of(emprestimoDTO.fromEmprestimo(emprestimo));
        } else {
            return Optional.empty();
        }
    }

    // Deletar empréstimo
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}