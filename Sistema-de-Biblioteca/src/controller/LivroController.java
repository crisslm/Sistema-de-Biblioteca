package controller;

import model.Autor;
import service.LivroService;

import java.util.Scanner;

public class LivroController {
    Scanner sc = new Scanner(System.in);
    private final LivroService livroService;
    private final AutorController autorController;

    public LivroController(LivroService livroService, AutorController autorController){
        this.livroService = livroService;
        this.autorController = autorController;
    }

    public void cadastrar_livro(){
        System.out.println("Cadastrando novo Livro: \n");
        System.out.print("Titulo: ");
        String titulo = sc.nextLine();
        Autor novoAutor = autorController.cadastrar_autor();
        livroService.cadastrar_novo_livro(titulo, novoAutor);
    }

    public void listar_livros(){
        livroService.listar_livros();
    }


}
