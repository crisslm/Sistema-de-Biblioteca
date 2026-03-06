package controller;

import repository.*;
import service.*;

public class MainController {
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

    HistoricoRepository historicoRepository = new HistoricoRepository();
    HistoricoService historicoService = new HistoricoService(historicoRepository);
    HistoricoController historicoController = new HistoricoController(historicoService, clienteService);

    EmprestimoRepository emprestimoRepository = new EmprestimoRepository();
    EmprestimoService emprestimoService = new EmprestimoService(emprestimoRepository, historicoRepository);
    EmprestimoController emprestimoController = new EmprestimoController(emprestimoService, clienteService, menuService, livroService);

    public void start(){
        int optionsMenuPrincipal = menuController.menu_principal();
        while(optionsMenuPrincipal != 0){
            switch ((optionsMenuPrincipal)){
                case 1 -> { //CADASTRAR CLIENTE
                    clienteController.cadastrar_cliente();
                    optionsMenuPrincipal = menuController.menu_principal();
                }
                case 2 -> { //CADASTRAR LIVRO
                    livroController.cadastrar_livro();
                    optionsMenuPrincipal = menuController.menu_principal();
                }
                case 3 -> { //BUSCAR LIVRO
                    int menuBuscarLivro = menuController.menu_buscar_livro();
                    switch (menuBuscarLivro){
                        case 1 -> { //POR ID
                            livroController.buscar_livro_id();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 2 -> { //POR TITULO
                            livroController.buscar_livro_titulo();
                            optionsMenuPrincipal = menuController.menu_principal();
                            
                        }
                    }
                }
                case 4 -> { //BUSCAR CLIENTE
                    int menuBuscarCliente = menuController.menu_buscar_cliente();
                    switch (menuBuscarCliente){
                        case 1 -> { //POR ID
                            clienteController.buscar_cliente_id();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 2 -> { //POR NOME
                            clienteController.buscar_cliente_nome();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 3 -> { //POR EMAIL
                            clienteController.buscar_cliente_email();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                    }
                }
                case 5 -> { //LISTAR LIVROS
                    int optionsFiltragemLivro = menuController.menu_filtragem_livros();
                    switch (optionsFiltragemLivro){
                        case 1 -> { //POR TITULO
                            livroController.listar_livros_por_titulo();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 2 -> { //POR AUTOR
                            livroController.listar_livros_por_autor();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 3 -> { //POR DISPONIVEIS
                            livroController.listar_livros_disponiveis();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                        case 4 -> { //NAO FILTRAR
                            livroController.listar_livros();
                            optionsMenuPrincipal = menuController.menu_principal();
                        }
                    }
                }
                case 6 -> {
                    clienteController.listar_clientes();
                    optionsMenuPrincipal = menuController.menu_principal();
                }
                case 7 -> {
                    emprestimoController.emprestimo_livro();
                    optionsMenuPrincipal = menuController.menu_principal();

                }
                case 8 -> {
                    emprestimoController.devolucao_livro();
                    optionsMenuPrincipal = menuController.menu_principal();

                }
                case 9 -> {
                    historicoController.listar_historico_cliente();
                    optionsMenuPrincipal = menuController.menu_principal();
                }
            }
        }
    }
}
