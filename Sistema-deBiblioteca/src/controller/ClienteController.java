package controller;

import service.ClienteService;

import java.util.Scanner;

public class ClienteController {
    Scanner sc = new Scanner(System.in);
    ClienteService clienteService;

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
    }

    public void listar_clientes(){
        clienteService.listar_clientes();
    }
}
