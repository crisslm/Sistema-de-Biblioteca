package controller;

import model.Cliente;
import model.Livro;
import service.ClienteService;
import service.EmprestimoService;
import service.LivroService;
import service.MenuService;
import util.Util;

import java.util.Scanner;

public class EmprestimoController {
    Scanner sc = new Scanner(System.in);
    Util util = new Util();
    private final EmprestimoService emprestimoService;
    private final ClienteService clienteService;
    private final MenuService menuService;
    private final LivroService livroService;

    public EmprestimoController(EmprestimoService emprestimoService,
                                ClienteService clienteService,
                                MenuService menuService,
                                LivroService livroService){
        this.emprestimoService = emprestimoService;
        this.clienteService = clienteService;
        this.menuService = menuService;
        this.livroService = livroService;
    }

    public void emprestimo_livro(){
        livroService.listar_livros();
        System.out.println("Realizando emprestimo: ");
        System.out.println("======================");
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = clienteService.buscar_nome(nome);
        if(cliente == null){
            System.out.println("Cliente não cadastrado.");
            return;
        }
        int opcao = menuService.menu_escolhe_livro();
        Livro livro = util.busca_livro(livroService, opcao);
        emprestimoService.emprestimo_livro(cliente, livro);
        System.out.printf("Livro %s de %s emprestado com sucesso!\n", livro.getTitulo(), livro.getAutor().getNome());
    }
}
