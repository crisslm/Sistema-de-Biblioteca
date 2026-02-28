package main;

import controller.ClienteController;
import repository.ClienteRepository;
import service.ClienteService;

public class Main {
    public static void main(String [] args){
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);

        clienteController.cadastrar_cliente();
        clienteController.listar_clientes();
    }
}
