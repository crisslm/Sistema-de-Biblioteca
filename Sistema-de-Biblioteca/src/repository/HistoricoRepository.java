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

    public void salvar_emprestimo(Emprestimo emprestimo, EmprestimoRepository emprestimoRepository){

        Historico historico = new Historico();
    }

    public void deletar(Historico historico){
        historicos.remove(historico);
    }



    public List<Historico> listar_historico(){
        return historicos;
    }
}
