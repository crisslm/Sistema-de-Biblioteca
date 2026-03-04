package model;

import repository.EmprestimoRepository;

import java.util.List;

public class Historico {
    private Cliente cliente;
    private List<Emprestimo> emprestimos;

    public Historico(Cliente cliente, List<Emprestimo> emprestimos) {
        this.cliente = cliente;
        this.emprestimos = emprestimos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionar_emprestimo(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }
}