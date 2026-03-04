package repository;

import model.Emprestimo;
import model.Historico;

import java.util.ArrayList;
import java.util.List;

public class HistoricoRepository {
    List<Historico> historicos = new ArrayList<>();

    public void salvar(Historico historico){
        historicos.add(historico);
    }

    public void salvar_emprestimo(Emprestimo emprestimo, List<Emprestimo> emprestimos){
        Historico historico = new Historico(emprestimo.getCliente(), emprestimos);
    }

    public List<Historico> listar_historicos(){
        return historicos;
    }
}
