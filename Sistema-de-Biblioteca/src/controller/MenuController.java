package controller;
import service.MenuService;
import util.Util;

import java.util.Scanner;

public class MenuController {
    Util util = new Util();
    Scanner sc = new Scanner(System.in);
    private MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }

    public int menu_principal(){
        return menuService.menu_principal();
    }

    public int menu_buscar_livro(){
        return menuService.menu_buscar_livro();
    }

    public int menu_buscar_cliente(){
        return menuService.menu_buscar_cliente();
    }

    public  int menu_filtragem_livros(){
        return menuService.menu_filtragem_livros();
    }
}
