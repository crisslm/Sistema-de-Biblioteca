package repository;

import model.Historico;

import java.util.ArrayList;
import java.util.List;

public class HistoricoRepository {
    List<Historico> historicos = new ArrayList<>();

    public void salvar(Historico historico){
        historicos.add(historico);
    }

    public void deletar(Historico historico){
        historicos.remove(historico);
    }

    public Historico buscar(String id) {
        for (Historico historico : historicos) {
            if (historico.getCliente().getId().equals(id)) {
                return historico;
            }
        }
        return null;
    }

    public List<Historico> lista_historico(){
        return historicos;
    }
}
