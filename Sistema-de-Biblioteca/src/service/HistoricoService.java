package service;

import model.Cliente;
import model.Emprestimo;
import model.Historico;
import repository.EmprestimoRepository;
import repository.HistoricoRepository;
import util.Util;

import java.util.ArrayList;
import java.util.List;

public class HistoricoService{
    Util util = new Util();
    private HistoricoRepository historicoRepository;

    public HistoricoService(HistoricoRepository historicoRepository){
        this.historicoRepository = historicoRepository;
    }

    public void adicionar_emprestimo_no_historico(Cliente cliente, EmprestimoRepository emprestimoRepository){
        List<Emprestimo> emprestimosDoCliente = new ArrayList<>();
        Historico historicoAtual = null;
        for(Historico historico : historicoRepository.listar_historico()){
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
        }

        for(Emprestimo emprestimo : emprestimoRepository.lista_emprestimos()){
            if(emprestimo.getCliente().getId().equals(cliente.getId())){
                historicoAtual.adicionar_emprestimo(emprestimo);
            }
        }


    }
}
