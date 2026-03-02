package main;

import controller.AutorController;
import controller.ClienteController;
import controller.LivroController;
import repository.AutorRepository;
import repository.ClienteRepository;
import repository.LivroRepository;
import service.AutorService;
import service.ClienteService;
import service.LivroService;

public class Main {
    public static void main(String [] args){
        AutorRepository autorRepository = new AutorRepository();
        AutorService autorService = new AutorService(autorRepository);
        AutorController autorController = new AutorController(autorService);
        LivroRepository livroRepository = new LivroRepository();
        LivroService livroService = new LivroService(livroRepository);
        LivroController livroController= new LivroController(livroService, autorController);

        livroController.cadastrar_livro();
        livroController.cadastrar_livro();
        livroController.listar_livros();


    }
}
