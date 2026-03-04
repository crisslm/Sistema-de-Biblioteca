package controller;

import model.Cliente;
import service.ClienteService;

import java.util.Scanner;

public class ClienteController {
    Scanner sc = new Scanner(System.in);
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void cadastrar_cliente(){
        String nome;
        String email;
        System.out.println("Cadastro do Cliente:\n");
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Email: ");
        email = sc.nextLine();
        clienteService.cadastrar_novo_cliente(nome, email);
        System.out.println("Cliente cadastrado com sucesso!\n");
    }

    public void listar_clientes(){
        clienteService.listar_clientes();
    }

    public void buscar_cliente_id(){
        System.out.println("Buscando Cliente por ID: \n");
        System.out.print("ID do cliente: ");
        String id = sc.nextLine();
        Cliente cliente = clienteService.buscar_cliente_id(id);
        if(cliente == null){
            System.out.println("Cliente nao encontrado.\n");
            return;
        }
        clienteService.printar_cliente(cliente);
    }

    public void buscar_cliente_nome(){
        System.out.println("Buscando Cliente por nome: \n");
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = clienteService.buscar_cliente_nome(nome);
        if(cliente == null){
            System.out.println("Cliente nao encontrado.\n");
            return;
        }
        clienteService.printar_cliente(cliente);
    }

    public void buscar_cliente_email(){
        System.out.println("Buscando Cliente por email: \n");
        System.out.print("Email do cliente: ");
        String email = sc.nextLine();
        Cliente cliente = clienteService.buscar_cliente_email(email);
        if(cliente == null){
            System.out.println("Cliente nao encontrado.\n");
            return;
        }
        clienteService.printar_cliente(cliente);
    }
}
