package service;

import model.Cliente;
import model.Emprestimo;
import model.Livro;
import repository.EmprestimoRepository;
import util.Util;

import java.time.LocalDate;

public class EmprestimoService {
    Util util = new Util();
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }

    public void emprestimo_livro(Cliente cliente, Livro livro){
        String id;
        do {
            id = util.idGenerator();
        } while(util.sameEmprestimoId(emprestimoRepository, id));

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusMonths(1);

        Emprestimo novoEmprestimo = new Emprestimo(id, livro, cliente, dataEmprestimo, dataDevolucao);
        emprestimoRepository.salvar(novoEmprestimo);
        livro.setDisponivel(false);
    }
}
