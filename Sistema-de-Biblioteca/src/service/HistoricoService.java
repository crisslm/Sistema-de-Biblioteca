package service;

import model.Cliente;
import model.Emprestimo;
import model.Historico;
import repository.EmprestimoRepository;
import repository.HistoricoRepository;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoricoService{
    Util util = new Util();
    private final HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository){
        this.historicoRepository = historicoRepository;
    }

    public void adicionar_emprestimo_no_historico(Cliente cliente, EmprestimoRepository emprestimoRepository){
        List<Emprestimo> emprestimosDoCliente = new ArrayList<>();
        Historico historicoAtual = null;
        for(Historico historico : historicoRepository.listar_historicos()){
            if(historico.getCliente().getId().equals(cliente.getId())){
                historicoAtual = historico;
            }
        }
        if(historicoAtual == null){
            List<Emprestimo> emprestimos = new ArrayList<>();
            for(Emprestimo emprestimo : emprestimoRepository.lista_emprestimos()){
                if(emprestimo.getCliente().getId().equals(cliente.getId())){
                    emprestimos.add(emprestimo);
                }
            }
            Historico novoHistorico = new Historico(cliente, emprestimos);
            historicoRepository.salvar(novoHistorico);
            return;
        }

        for(Emprestimo emprestimo : emprestimoRepository.lista_emprestimos()){
            if(emprestimo.getCliente().getId().equals(cliente.getId())){
                historicoAtual.adicionar_emprestimo(emprestimo);
            }
        }
    }

    public void listar_historico_cliente(Cliente cliente){
        Historico historicoAtual = null;
        for(Historico historico : historicoRepository.listar_historicos()){
            if(historico.getCliente().getId().equals(cliente.getId())){
                historicoAtual = historico;
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(historicoAtual == null){
            return;
        }
        System.out.printf("Historico do(a) Cliente %s: \n", historicoAtual.getCliente().getNome());
        System.out.printf("Id do cliente: %s\n", cliente.getId());
        System.out.println("============================");
        for(Emprestimo emprestimo : historicoAtual.getEmprestimos()){
            System.out.printf("Id do emprestimo: %s\n", emprestimo.getId());
            System.out.printf("Livro emprestado: %s\n", emprestimo.getLivro().getTitulo());
            System.out.printf("Data do emprestimo: %s\n", formatter.format(emprestimo.getDataEmprestimo()));
            System.out.printf("Data de devolucao: $s\n", formatter.format(emprestimo.getDataDevolucao()));
            System.out.println("============================");
        }
    }

    public List<Historico> lista_historicos(){
        return historicoRepository.listar_historicos();
    }
}
