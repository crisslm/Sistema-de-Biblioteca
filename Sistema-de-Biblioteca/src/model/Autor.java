package model;

import java.time.LocalDate;

public class Autor {
    private final String id;
    private final String nome;
    private final LocalDate dataNascimento;

    public Autor(String id, String nome, LocalDate dataNascimento){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
