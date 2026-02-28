# 📚 Sistema de Gerenciamento de Biblioteca — Java Console

## 📖 Sobre o Projeto

Este projeto consiste em um sistema de console desenvolvido em **Java** para gerenciamento de uma biblioteca, permitindo controlar:

* Cadastro e consulta de livros
* Gerenciamento de autores
* Cadastro de clientes
* Registro de empréstimos
* Histórico de operações

O sistema foi estruturado seguindo uma arquitetura em camadas, separando responsabilidades e facilitando manutenção, escalabilidade e organização do código.

---

## 🎯 Objetivo do Sistema

Permitir que o usuário interaja com a biblioteca via console para:

✔ Visualizar livros disponíveis
✔ Registrar empréstimos
✔ Gerenciar clientes
✔ Consultar histórico
✔ Controlar disponibilidade de livros
✔ Organizar dados em memória simulando um banco de dados

---

## ⚙️ Fluxo Básico de Funcionamento

1. O sistema inicia exibindo um menu interativo.
2. O usuário escolhe uma operação (listar livros, emprestar, cadastrar cliente etc.).
3. O sistema executa a lógica correspondente.
4. As informações são armazenadas em listas em memória.
5. O sistema permanece em execução até o usuário optar por sair.

---

## 🧱 Arquitetura do Projeto

O sistema está organizado em pacotes com responsabilidades bem definidas.

```
Sistema-deBiblioteca/
 └── src/
     ├── controller/
     │    ├── AutorController.java
     │    ├── ClienteController.java
     │    ├── EmprestimoController.java
     │    ├── HistoricoController.java
     │    ├── LivroController.java
     │    └── MenuController.java
     │
     ├── main/
     │    └── Main.java
     │
     ├── model/
     │    ├── Autor.java
     │    ├── Cliente.java
     │    ├── Emprestimo.java
     │    ├── Historico.java
     │    └── Livro.java
     │
     ├── repository/
     │    ├── AutorRepository.java
     │    ├── ClienteRepository.java
     │    ├── EmprestimoRepository.java
     │    ├── HistoricoRepository.java
     │    └── LivroRepository.java
     │
     ├── service/
     │    ├── AutorService.java
     │    ├── ClienteService.java
     │    ├── EmprestimoService.java
     │    ├── HistoricoService.java
     │    └── LivroService.java
     │
     └── util/
          └── Util.java
```

---

## 🧩 Responsabilidade de Cada Camada

### ▶ main

Ponto de entrada da aplicação.

Responsável por:

* Inicializar o sistema
* Executar o menu principal
* Iniciar o fluxo da aplicação

---

### ▶ controller

Responsável pela interação com o usuário.

Funções principais:

* Receber comandos do console
* Exibir menus e mensagens
* Encaminhar requisições para a camada de serviço

#### Componentes

* **MenuController** → controla o menu principal e navegação
* **ClienteController** → operações relacionadas a clientes
* **Controller (base)** → pode centralizar comportamentos comuns

---

### ▶ model

Representa as entidades do domínio do sistema.

#### Autor

* id
* nome
* dataNascimento

#### Livro

* id
* titulo
* autor
* disponivel
* dataCadastro
* dataAtualizacao

#### Cliente

* id
* nome
* email

#### Emprestimo

* id
* livro
* cliente
* dataEmprestimo
* dataDevolucao

#### Historico

Registra eventos do sistema:

* empréstimos realizados
* devoluções
* alterações relevantes

---

### ▶ repository

Responsável pela persistência em memória.

Simula um banco de dados utilizando listas.

Exemplo conceitual:

```
List<Livro>
List<Autor>
List<Cliente>
List<Emprestimo>
List<Historico>
```

Funções:

* salvar
* buscar
* listar
* atualizar
* remover

---

### ▶ service

Contém a lógica de negócio da aplicação.

Responsabilidades:

* validar regras do sistema
* controlar empréstimos
* verificar disponibilidade
* registrar histórico
* gerenciar clientes e livros

Cada entidade possui seu próprio serviço especializado.

---

### ▶ util

Classes auxiliares reutilizáveis.

Exemplos:

* leitura de dados do console
* formatação de datas
* geração de IDs
* mensagens padronizadas
* validações genéricas

---

## 🚀 Funcionalidades Implementadas

✔ Estrutura em camadas
✔ Cadastro de autores
✔ Cadastro de livros
✔ Cadastro de clientes
✔ Registro de empréstimos
✔ Controle de disponibilidade
✔ Registro de histórico
✔ Menu interativo
✔ Organização modular do sistema

---

## 💡 Possíveis Evoluções do Sistema

### Persistência Real

* Banco de dados relacional
* JPA / Hibernate

### Interface Gráfica

* JavaFX
* Swing

### API Web

* Spring Boot REST

### Funcionalidades Extras

* devolução de livros
* multas por atraso
* reservas
* autenticação de usuários
* relatórios
* exportação de dados

---

## 🎓 Conceitos Aplicados

* Programação Orientada a Objetos
* Arquitetura em camadas
* Separação de responsabilidades
* Encapsulamento
* Manipulação de coleções
* Interação com usuário via console
* Organização de projeto escalável
* Simulação de persistência

---

## ▶ Como Executar

### Requisitos

* Java JDK 8+
* IDE Java

### Passos

1. Abrir o projeto na IDE
2. Executar:

```
main/Main.java
```

---

## 📌 Objetivo Educacional

Este projeto foi desenvolvido para consolidar conhecimentos em:

* Estruturação de projetos Java
* Boas práticas de arquitetura
* Desenvolvimento de sistemas orientados a domínio
* Organização de código profissional

---

## 👨‍💻 Autor

Projeto acadêmico para prática de desenvolvimento em Java com arquitetura organizada.

---

## 📄 Licença

Uso livre para fins educacionais.



