package controller;
import util.Util;

public class MenuController {
    Util util = new Util();

    public void menuPrincipal(){
        System.out.println("O que deseja fazer?");
        System.out.println("[1]Cadastrar novo cliente.");
        System.out.println("[2]Cadastrar novo Livro.");
        System.out.println("[3]Buscar livro pelo titulo.");
        System.out.println("[4]Buscar livro pelo autor.");
        System.out.println("[5]Listar Livros.");
        System.out.println("[6]Listar Clientes.");
        System.out.println("[7]Emprestimo.");
        System.out.println("[0]Sair.");
    }
}
