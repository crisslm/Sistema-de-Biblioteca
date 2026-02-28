package repository;

import model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository {
    List<Livro> livros = new ArrayList<>();

    public void salvar(Livro livro){
        livros.add(livro);
    }

    public void deletar(Livro livro){
        livros.remove(livro);
    }

    public Livro buscar(String id) {
        for (Livro livros : livros) {
            if (livros.getId().equals(id)) {
                return livros;
            }
        }
        return null;
    }

    public List<Livro> lista_livros(){
        return livros;
    }

}
