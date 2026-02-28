package model;

import java.time.LocalDate;

public class Emprestimo {
    private final String id;
    private final Livro livro;
    private final Cliente cliente;
    LocalDate dataEmprestimo;
    LocalDate dataDevolucao;

    public Emprestimo(String id, Livro livro, Cliente cliente, LocalDate dataEmprestimo, LocalDate dataDevolucao){
        this.id = id;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    //GETTERS e SETTERS

    public String getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
}
