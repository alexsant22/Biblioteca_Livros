# Biblioteca_Livros
Atividade de Java Spring Boot, sobre empréstimo de livros.

# Sistema de Biblioteca

Este projeto visa o desenvolvimento de um sistema de gestão de uma biblioteca, que envolve o relacionamento entre três entidades principais: **Cliente**, **Empréstimo** e **Livro**. O objetivo é implementar funcionalidades básicas para o cadastro, edição, remoção e busca de dados dessas entidades.

## Entidades

O sistema envolve três classes principais, que estão relacionadas da seguinte forma:

### 1. **Cliente**
- **Atributos**:
  - `id`: Identificador único do cliente.
  - `nome`: Nome do cliente.
  - `sobrenome`: Sobrenome do cliente.
  - `cpf`: CPF único do cliente (não pode haver dois clientes com o mesmo CPF).

### 2. **Empréstimo**
- **Atributos**:
  - `id`: Identificador único do empréstimo.
  - `data_inicial`: Data inicial do empréstimo.
  - `data_final`: Data final do empréstimo.

### 3. **Livro**
- **Atributos**:
  - `id`: Identificador único do livro.
  - `nome`: Nome do livro.
  - `autor`: Autor do livro.
  - `ISBN`: Número único de identificação do livro.
  - `genero`: Gênero do livro.

## Relacionamentos

- **Cliente 1 --- 1 Empréstimo 1 ----- N Livro**: 
  - Um cliente pode realizar apenas um empréstimo de cada vez, mas esse empréstimo pode conter vários livros.
  - Um livro pode estar presente em múltiplos empréstimos de diferentes clientes, mas cada empréstimo está associado a um único cliente.

## Atividades

### 1. Diagrama UML

- Criar um diagrama UML para representar as entidades **Cliente**, **Empréstimo** e **Livro**, e os relacionamentos entre elas.

### 2. Rotas

Implemente as seguintes rotas para manipulação das entidades:

- **Cliente**:
  - `POST /clientes`: Adicionar um novo cliente.
  - `DELETE /clientes/{id}`: Remover um cliente.
  - `PUT /clientes/{id}`: Editar um cliente.
  - `GET /clientes`: Buscar todos os clientes.

- **Empréstimo**:
  - `POST /emprestimos`: Adicionar um novo empréstimo.
  - `DELETE /emprestimos/{id}`: Remover um empréstimo.
  - `PUT /emprestimos/{id}`: Editar um empréstimo.
  - `GET /emprestimos`: Buscar todos os empréstimos.

- **Livro**:
  - `POST /livros`: Adicionar um novo livro.
  - `DELETE /livros/{id}`: Remover um livro.
  - `PUT /livros/{id}`: Editar um livro.
  - `GET /livros`: Buscar todos os livros.

### 3. Telas

Implemente as seguintes telas para interação com o sistema:

- **Cadastro**:
  - Tela para cadastrar novos **clientes**, **empréstimos** e **livros**.
  
- **Edição**:
  - Tela para editar **clientes**, **empréstimos** e **livros** existentes.
  
- **Listagem/Remoção**:
  - Tela para listar todos os **clientes**, **empréstimos** e **livros**, com opção de remoção.

## Requisitos Adicionais

### **Bônus**: Filtro por Gênero do Livro

- Implemente a funcionalidade de filtro de livros por gênero, permitindo ao usuário buscar livros de um determinado gênero.