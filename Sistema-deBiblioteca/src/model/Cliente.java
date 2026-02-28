package model;
public class Cliente{
    private final String id;
    private final String nome;
    private final String email;

    public Cliente(String id, String nome, String email){
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    //GETTERS

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
