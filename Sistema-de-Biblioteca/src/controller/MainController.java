package controller;

import repository.AutorRepository;
import repository.ClienteRepository;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import service.*;

public class MainController {
    AutorRepository autorRepository = new AutorRepository();
    AutorService autorService = new AutorService(autorRepository);
    AutorController autorController = new AutorController(autorService);
    LivroRepository livroRepository = new LivroRepository();
    ClienteRepository clienteRepository = new ClienteRepository();
    ClienteService clienteService = new ClienteService(clienteRepository);
    ClienteController clienteController = new ClienteController(clienteService);
    LivroService livroService = new LivroService(livroRepository);
    LivroController livroController = new LivroController(livroService, autorController);
    MenuService menuService = new MenuService();
    MenuController menuController = new MenuController(menuService);
    EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository);
    EmprestimoController emprestimoController = new EmprestimoController(emprestimoService, clienteService, menuService, livroService);
}
