package model;

public class Historico{
    private Cliente cliente;
    private Emprestimo emprestimo;

    public Historico(Cliente cliente, Emprestimo emprestimo){
        this.cliente = cliente;
        this.emprestimo = emprestimo;
    }

    //GETTERS

    public Cliente getCliente() {
        return cliente;
    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }
}