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
}
