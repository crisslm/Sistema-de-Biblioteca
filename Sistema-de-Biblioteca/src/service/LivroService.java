package service;

import model.Livro;
import model.Autor;
import repository.LivroRepository;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroService {
    Util util = new Util();
    LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public void cadastrar_novo_livro(String titulo, Autor autor){
        String id;
        do {
            id = util.idGenerator();
        } while(util.sameBookId(livroRepository, id));

        LocalDate dataCadastro = LocalDate.now();
        LocalDate dataAtualizacao = LocalDate.now();

        Livro novoLivro = new Livro(id, titulo, autor, dataCadastro, dataAtualizacao);
        livroRepository.salvar(novoLivro);
    }

    public String livro_disponivel(Livro livro) {
        if (livro.getDisponivel()) {
            return "Disponivel";
        } else {
            return "Indisponivel";
        }
    }

    public boolean existe_livros(){
        if(livroRepository.lista_livros().isEmpty()){
            return false;
        }
        return true;
    }

    public void listar_livros(){
        System.out.println("============================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int count = 0;
        for(Livro livro : livroRepository.lista_livros()){
            System.out.printf("Status: %s\n", livro_disponivel(livro));
            System.out.printf("ID: %s\n", livro.getId());
            System.out.printf("Titulo: %s\n", livro.getTitulo());
            System.out.printf("Autor: %s\n", livro.getAutor().getNome());
            System.out.printf("Nascimento do Autor: %s\n", formatter.format(livro.getAutor().getDataNascimento()));
            System.out.printf("Data de cadastro: %s\n", formatter.format(livro.getDataCadastro()));
            System.out.println("============================");
            count++;
        }
        if(count == 0){
            System.out.println("Nenhum livro encontrado no momento.\n");
            System.out.println("============================");
        }
    }

    public void listar_livros_disponiveis(){
        System.out.println("============================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int count = 0;
        for(Livro livro : livroRepository.lista_livros()){
            if(livro.getDisponivel()){
                System.out.printf("Status: %s\n", livro_disponivel(livro));
                System.out.printf("ID: %s\n", livro.getId());
                System.out.printf("Titulo: %s\n", livro.getTitulo());
                System.out.printf("Autor: %s\n", livro.getAutor().getNome());
                System.out.printf("Nascimento do Autor: %s\n", formatter.format(livro.getAutor().getDataNascimento()));
                System.out.printf("Data de cadastro: %s\n", formatter.format(livro.getDataCadastro()));
                System.out.println("============================");
                count++;
            }
        }
        if(count == 0){
            System.out.println("Nenhum livro disponivel foi encontrado.\n");
            System.out.println("============================");
        }
    }

    public void listar_livros_por_titulo(String titulo){
        System.out.println("============================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int count = 0;
        for(Livro livro : livroRepository.lista_livros()){
            if(livro.getTitulo().equals(titulo)){
                System.out.printf("Status: %s\n", livro_disponivel(livro));
                System.out.printf("ID: %s\n", livro.getId());
                System.out.printf("Titulo: %s\n", livro.getTitulo());
                System.out.printf("Autor: %s\n", livro.getAutor().getNome());
                System.out.printf("Nascimento do Autor: %s\n", formatter.format(livro.getAutor().getDataNascimento()));
                System.out.printf("Data de cadastro: %s\n", formatter.format(livro.getDataCadastro()));
                System.out.println("============================");
                count++;
            }
        }
        if(count == 0){
            System.out.println("Nenhum livro com esse titulo foi encontrado.\n");
            System.out.println("============================");
        }
    }

    public void listar_livros_por_autor(String autor){
        System.out.println("============================");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        int count = 0;
        for(Livro livro : livroRepository.lista_livros()){
            if(livro.getAutor().equals(autor)){
                System.out.printf("Status: %s\n", livro_disponivel(livro));
                System.out.printf("ID: %s\n", livro.getId());
                System.out.printf("Titulo: %s\n", livro.getTitulo());
                System.out.printf("Autor: %s\n", livro.getAutor().getNome());
                System.out.printf("Nascimento do Autor: %s\n", formatter.format(livro.getAutor().getDataNascimento()));
                System.out.printf("Data de cadastro: %s\n", formatter.format(livro.getDataCadastro()));
                System.out.println("============================");
                count++;
            }
        }
        if(count == 0){
            System.out.println("Nenhum livro com esse autor foi encontrado.\n");
            System.out.println("============================");
        }
    }



    public Livro buscar_id(String id) {
        for (Livro livro : livroRepository.lista_livros()) {
            if (livro.getId().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    public Livro buscar_titulo(String titulo) {
        for (Livro livro : livroRepository.lista_livros()) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public Livro buscar_autor(String autor) {
        for (Livro livro : livroRepository.lista_livros()) {
            if (livro.getAutor().getNome().equals(autor)) {
                return livro;
            }
        }
        return null;
    }

    public void printar_livro(Livro livro){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("============================");
        System.out.printf("Status: %s\n", livro_disponivel(livro));
        System.out.printf("ID: %s\n", livro.getId());
        System.out.printf("Titulo: %s\n", livro.getTitulo());
        System.out.printf("Autor: %s\n", livro.getAutor().getNome());
        System.out.printf("Nascimento do Autor: %s\n", formatter.format(livro.getAutor().getDataNascimento()));
        System.out.printf("Data de cadastro: %s\n", formatter.format(livro.getDataCadastro()));
        System.out.println("============================");
    }
}
