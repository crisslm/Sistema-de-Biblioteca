package service;

import util.Util;

import java.util.Scanner;

public class MenuService {
    Util util = new Util();
    Scanner sc = new Scanner(System.in);

    public int menu_principal(){
        System.out.println("============================");
        System.out.println("O que deseja fazer?");
        System.out.println("[1]Cadastrar novo cliente.");
        System.out.println("[2]Cadastrar novo Livro.");
        System.out.println("[3]Buscar livro.");
        System.out.println("[4]Buscar cliente.");
        System.out.println("[5]Listar Livros.");
        System.out.println("[6]Listar Clientes.");
        System.out.println("[7]Emprestimo.");
        System.out.println("[8]Devolucao");
        System.out.println("[9]Historico do cliente");
        System.out.println("[0]Sair.");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 0, 9);
        System.out.println("===========================");
        return opcao;
    }

    public int menu_filtragem_livros(){
        System.out.println("============================");
        System.out.println("Como deseja filtrar?");
        System.out.println("[1]Filtrar por Titulo.");
        System.out.println("[2]Filtrar por Autor.");
        System.out.println("[3]Filtrar disponiveis.");
        System.out.println("[4]Não Filtrar.\n");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 1, 4);
        System.out.println("============================");
        return opcao;
    }

    public int menu_buscar_livro(){
        System.out.println("============================");
        System.out.println("Como quer buscar o livro?");
        System.out.println("[1]ID");
        System.out.println("[2]Titulo");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 1, 2);
        System.out.println("============================");
        return opcao;
    }

    public int menu_buscar_cliente(){
        System.out.println("============================");
        System.out.println("Como quer buscar?");
        System.out.println("[1]Por ID");
        System.out.println("[2]Por nome.");
        System.out.println("[3]Por email.");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 1, 3);
        System.out.println("============================");
        return opcao;
    }
}
