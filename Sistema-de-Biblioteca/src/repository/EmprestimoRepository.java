package repository;

import model.Emprestimo;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoRepository {
    List<Emprestimo> emprestimos = new ArrayList<>();

    public void salvar(Emprestimo emprestimo){
        emprestimos.add(emprestimo);
    }

    public void deletar(Emprestimo emprestimo){
        emprestimos.remove(emprestimo);
    }

    public List<Emprestimo> lista_emprestimos(){
        return emprestimos;
    }
}
