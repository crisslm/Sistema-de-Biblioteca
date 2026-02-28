package repository;

import model.Autor;
import model.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente){
        clientes.add(cliente);
    }

    public void deletar(Cliente cliente){
        clientes.remove(cliente);
    }

    public Cliente buscar(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> lista_clientes(){
        return clientes;
    }
}
