package main;

import controller.*;
import repository.AutorRepository;
import repository.ClienteRepository;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import service.*;

public class Main {
    public static void main(String [] args){
        MainController mainController = new MainController();
        mainController.start();
    }
}
