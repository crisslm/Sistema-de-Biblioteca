package main;

import controller.*;
import repository.AutorRepository;
import repository.ClienteRepository;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import service.*;

public class Main {
    public static void main(String [] args){
        AutorRepository autorRepository = new AutorRepository();
        AutorService autorService = new AutorService(autorRepository);
        AutorController autorController = new AutorController(autorService);
        LivroRepository livroRepository = new LivroRepository();
        LivroService livroService = new LivroService(livroRepository);
        LivroController livroController = new LivroController(livroService, autorController);
        ClienteRepository clienteRepository = new ClienteRepository();
        ClienteService clienteService = new ClienteService(clienteRepository);
        ClienteController clienteController = new ClienteController(clienteService);
        MenuService menuService = new MenuService();
        MenuController menuController = new MenuController(menuService);
        EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
        EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);
        EmprestimoController emprestimoController = new EmprestimoController(emprestimoService, clienteService, menuService, livroService);

        clienteController.cadastrar_cliente();
        livroController.cadastrar_livro();
        emprestimoController.emprestimo_livro();
    }
}
