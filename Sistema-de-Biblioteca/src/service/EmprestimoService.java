package service;

import model.Cliente;
import model.Emprestimo;
import model.Livro;
import repository.EmprestimoRepository;
import repository.HistoricoRepository;
import util.Util;

import java.time.LocalDate;

public class EmprestimoService {
    Util util = new Util();
    private final EmprestimoRepository emprestimoRepository;
    private final HistoricoRepository historicoRepository;
    private final HistoricoService historicoService;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, HistoricoRepository historicoRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.historicoRepository = historicoRepository;
        historicoService = new HistoricoService(historicoRepository);
    }

    public void emprestimo_livro(Cliente cliente, Livro livro){
        String id;
        do {
            id = util.idGenerator();
        } while(util.sameEmprestimoId(emprestimoRepository, id));

        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataDevolucao = dataEmprestimo.plusMonths(1);
        livro.setDisponivel(false);
        Emprestimo novoEmprestimo = new Emprestimo(id, livro, cliente, dataEmprestimo, dataDevolucao);
        emprestimoRepository.salvar(novoEmprestimo);
        historicoService.adicionar_emprestimo_no_historico(cliente, emprestimoRepository);
    }

    public void devolucao_livro(Cliente cliente){
        int count = 0;
        Emprestimo devolucao = null;
        for(Emprestimo emprestimo : emprestimoRepository.lista_emprestimos()){
            if(emprestimo.getCliente().getId().equals(cliente.getId())){
                emprestimo.getLivro().setDisponivel(true);
                LocalDate dataAtt = LocalDate.now();
                emprestimo.getLivro().setDataAtualizacao(dataAtt);
                devolucao = emprestimo;
                System.out.println("Livro devolvido com sucesso!\n");
                count++;
            }
        }
        if(devolucao != null){
            emprestimoRepository.deletar(devolucao);
        }
        if(count == 0){
            System.out.printf("%s nao tem nenhuma devolucao pendente.\n\n", cliente.getNome());
        }
    }
}
