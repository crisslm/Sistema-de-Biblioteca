package controller;

import model.Autor;
import model.Livro;
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
        System.out.println("Livro cadastrado com sucesso!\n");
    }

    public void listar_livros(){
        livroService.listar_livros();
    }

    public void listar_livros_disponiveis(){
        livroService.listar_livros_disponiveis();
    }

    public void listar_livros_por_titulo(){
        System.out.print("Insira o titulo dos livros: ");
        String titulo = sc.nextLine();
        livroService.listar_livros_por_titulo(titulo);
    }

    public void listar_livros_por_autor(){
        System.out.print("Insira o autor dos livros: ");
        String autor = sc.nextLine();
        livroService.listar_livros_por_autor(autor);
    }


    public void buscar_livro_id(){
        System.out.println("Buscando Livro por ID: \n");
        System.out.print("ID do livro: ");
        String id = sc.nextLine();
        Livro livro = livroService.buscar_id(id);
        if(livro == null){
            System.out.println("Nenhum livro com esse ID foi encontrado.\n");
            return;
        }
        livroService.printar_livro(livro);
    }

    public void buscar_livro_titulo(){
        System.out.println("Buscando Livro por Titulo: \n");
        System.out.print("Titulo do livro: ");
        String id = sc.nextLine();
        Livro livro = livroService.buscar_titulo(id);
        if(livro == null){
            System.out.println("Nenhum livro com esse titulo foi encontrado.\n");
            return;
        }
        livroService.printar_livro(livro);
    }
}
