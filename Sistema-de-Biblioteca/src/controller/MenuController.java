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

    public int menuPrincipal(){
        return menuService.menu_principal();
    }
}
