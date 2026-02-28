package repository;

import java.util.ArrayList;
import java.util.List;
import model.Autor;

public class AutorRepository {
    List<Autor> autores = new ArrayList<>();

    public void salvar(Autor autor){
        autores.add(autor);
    }

    public void deletar(Autor autor){
        autores.remove(autor);
    }

    public Autor buscar(String id) {
        for (Autor autor : autores) {
            if (autor.getId().equals(id)) {
                return autor;
            }
        }
        return null;
    }

    public List<Autor> lista_autores(){
        return autores;
    }
}
