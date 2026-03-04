package service;

import util.Util;

import java.util.Scanner;

public class MenuService {
    Util util = new Util();
    Scanner sc = new Scanner(System.in);

    public int menu_principal(){
        System.out.println("O que deseja fazer?");
        System.out.println("[1]Cadastrar novo cliente.");
        System.out.println("[2]Cadastrar novo Livro.");
        System.out.println("[3]Buscar livro pelo titulo.");
        System.out.println("[4]Buscar livro pelo autor.");
        System.out.println("[5]Listar Livros.");
        System.out.println("[6]Listar Clientes.");
        System.out.println("[7]Emprestimo.");
        System.out.println("[0]Sair.");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 0, 7);
        return opcao;
    }

    public int menu_filtragem(){
        System.out.println("[1]Filtrar por Autor.\n");
        System.out.println("[2]Filtrar disponiveis.\n");
        System.out.println("[3]Não Filtra.\n");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 1, 3);
        return opcao;
    }

    public int menu_escolhe_livro(){
        System.out.println("Como quer buscar?");
        System.out.println("[1]ID");
        System.out.println("[2]Titulo");
        int opcao = -1;
        opcao = util.validar_opcao(opcao, 1, 2);
        return opcao;
    }
}
