package service;

import model.Cliente;
import repository.ClienteRepository;
import util.Util;

import java.util.Scanner;

public class ClienteService {
    Util util = new Util();
    Scanner sc = new Scanner(System.in);
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void cadastrar_novo_cliente(String nome, String email){
        String id;
        do {
            id = util.idGenerator();
        } while(util.sameClientId(clienteRepository, id));

        if(!util.emailValido(email)) System.out.println("Email invalido. Tente novamente\n");
        while(!util.emailValido(email)){
            System.out.print("Email: ");
            email = sc.nextLine();
            if(!util.emailValido(email))
                System.out.println("\nEmail Invalido. Tente novamente.\n");
        }

        Cliente cliente = new Cliente(id, nome, email);
        clienteRepository.salvar(cliente);
    }

    public void listar_clientes(){
        for(Cliente cliente : clienteRepository.lista_clientes()){
            System.out.println("------------------------");
            System.out.printf("ID: %s\n", cliente.getId());
            System.out.printf("Nome: %s\n", cliente.getNome());
            System.out.printf("Email: %s\n", cliente.getEmail());
        }
        System.out.println("------------------------");
    }
}
