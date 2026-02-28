package controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import model.Cliente;
import model.Livro;
import model.Autor;
import repository.AutorRepository;
import repository.ClienteRepository;
import repository.LivroRepository;
import util.Util;

public class Controller {
    Util tools = new Util();
    ClienteRepository clienteRepository;

    private final Scanner sc = new Scanner(System.in);

    public void cadastrar_novo_livro(LivroRepository livroRepository, AutorRepository autorRepository){
        //Criando o ID
        String id;
        do { 
            id = tools.idGenerator();
        } while(tools.sameBookId(livroRepository, id));

        //Pegando o nome do livro
        System.out.print("Nome do Livro: ");
        String titulo = sc.nextLine();

        Autor autor = tools.setAutor(autorRepository);

        LocalDate dataCadastro = LocalDate.now();
        LocalDate dataAtualizacao = LocalDate.now();
        
        Livro newLivro = new Livro(id, titulo, autor, dataCadastro, dataAtualizacao);
        autorRepository.salvar(autor);
        livroRepository.salvar(newLivro);
    }

}
