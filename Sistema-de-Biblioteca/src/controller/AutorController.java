package controller;

import model.Autor;
import repository.AutorRepository;
import service.AutorService;

import java.time.LocalDate;
import java.util.Scanner;

public class AutorController {
    Scanner sc = new Scanner(System.in);
    private final AutorService autorService;

    public AutorController(AutorService autorService){
        this.autorService = autorService;
    }

    public Autor cadastrar_autor(){
        String nome;
        String dataNascimento;
        System.out.print("Nome do autor: ");
        nome = sc.nextLine();
        System.out.print("Nascimento do autor(dd/mm/yyyy): ");
        dataNascimento = sc.nextLine();
        return autorService.cadastrar_autor(nome, dataNascimento);
    }
}
