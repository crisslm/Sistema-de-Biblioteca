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

        if(!util.emailValido(email)) System.out.println("Email invalido. Tente novamente.\n");
        while(!util.emailValido(email)){
            System.out.print("Email: ");
            email = sc.nextLine();
            if(!util.emailValido(email))
                System.out.println("\nEmail Invalido. Tente novamente.\n");
        }

        Cliente novoCliente = new Cliente(id, nome, email);
        clienteRepository.salvar(novoCliente);
    }

    public void deletar_cliente(String id){
        Cliente cliente = buscar_cliente_id(id);
        clienteRepository.deletar(cliente);
    } //Implementacao futura

    public Cliente buscar_cliente_id(String id) {
        for (Cliente cliente : clienteRepository.lista_clientes()) {
            if (cliente.getId().equals(id)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscar_cliente_nome(String nome){
        for(Cliente cliente : clienteRepository.lista_clientes()){
            if(nome.equals(cliente.getNome())){
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscar_cliente_email(String email){
        for(Cliente cliente : clienteRepository.lista_clientes()){
            if(email.equals(cliente.getEmail())){
                return cliente;
            }
        }
        return null;
    }

    public void listar_clientes(){
        int count = 0;
        for(Cliente cliente : clienteRepository.lista_clientes()){
            printar_cliente(cliente);
            count++;
        }
        if(count == 0){
            System.out.println("Nenhum cliente cadastrado.");
        }
    }

    public void printar_cliente(Cliente cliente){
        System.out.println("============================");
        System.out.printf("ID: %s\n", cliente.getId());
        System.out.printf("Nome: %s\n", cliente.getNome());
        System.out.printf("Email: %s\n", cliente.getEmail());
        System.out.println("============================");
    }
}
