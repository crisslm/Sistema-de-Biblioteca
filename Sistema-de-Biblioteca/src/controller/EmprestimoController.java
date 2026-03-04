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
        if(!livroService.existe_livros()){
            System.out.println("Nao ha como fazer emprestimos.\n");
        } else {
            System.out.println("Realizando emprestimo: ");
            System.out.println("============================");
            System.out.print("Nome do cliente: ");
            String nome = sc.nextLine();
            Cliente cliente = clienteService.buscar_cliente_nome(nome);
            if(cliente == null){
                System.out.println("Cliente não cadastrado.\n");
                System.out.println("============================");
                return;
            }
            int opcao = menuService.menu_buscar_livro();
            Livro livro = util.busca_livro(livroService, opcao);
            if(livro == null){
                System.out.println("Livro nao encontrado.\n");
                System.out.println("============================");
                return;
            }
            emprestimoService.emprestimo_livro(cliente, livro);
            System.out.printf("Livro %s de %s emprestado com sucesso!\n", livro.getTitulo(), livro.getAutor().getNome());
        }
    }

    public void devolucao_livro(){
        System.out.println("============================");
        System.out.println("Nome do cliente: ");
        String nome = sc.nextLine();
        Cliente cliente = clienteService.buscar_cliente_nome(nome);
        if(cliente == null){
            System.out.println("Cliente não encontrado.\n");
            return;
        }
        emprestimoService.devolucao_livro(cliente);
    }
}
