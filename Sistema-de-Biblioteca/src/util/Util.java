package util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import model.Autor;
import model.Cliente;
import model.Emprestimo;
import model.Livro;
import repository.*;
import service.LivroService;

public class Util {
    Scanner sc = new Scanner(System.in);


    public String idGenerator(){
        Random random = new Random();
        return String.valueOf(random.nextInt(999999));
    }

    public Autor setAutor(AutorRepository autorRepository){
        //Criando o ID
        String id;
        do { 
            id = idGenerator();
        } while(sameAuthorId(autorRepository, id));

        System.out.print("Nome do Autor: ");
        String autor = sc.nextLine();

        LocalDate dataDeNascimento;
        while(true){
            try {
                System.out.print("Nascimento do Autor(dd/mm/yyyy): ");
                String data = sc.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataDeNascimento = LocalDate.parse(data, formatter);
                break;
            } catch (Exception e) {
                System.out.println("Data invalida.");
            }
        }
        Autor newAutor = new Autor(id, autor, dataDeNascimento);
        return newAutor;
    }

    public boolean sameClientId(ClienteRepository clienteRepository, String id){
        for(Cliente cliente : clienteRepository.lista_clientes()){
            if(id.equals(cliente.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean sameBookId(LivroRepository livroRepository, String id){
        for(Livro livro : livroRepository.lista_livros()){
            if(id.equals(livro.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean sameEmprestimoId(EmprestimoRepository emprestimoRepository, String id){
        for(Emprestimo emprestimo : emprestimoRepository.lista_emprestimos()){
            if(id.equals(emprestimo.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean sameAuthorId(AutorRepository autorRepository, String id){
        for(Autor autor : autorRepository.lista_autores()){
            if(id.equals(autor.getId())){
                return true;
            }
        }
        return false;
    }

    public String statusFormatter(boolean disponivel){
        if(disponivel){
            return "Disponivel";
        } else{
            return "Indisponível";
        }
    }

    public boolean emailValido(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }

    public int validar_opcao(int opcao, int min, int max){
        while(true){
            try{
                System.out.print("Digite aqui: ");
                opcao = sc.nextInt();
                if(opcao > max || opcao < min){
                    System.out.println("Entrada invalida. Tente novamente.\n");
                    continue;
                } else{
                    break;
                }
            } catch (Exception e) {
                sc.next();
                System.out.println("Entrada invalida. Tente novamente.\n");
            }
        }
        return opcao;
    }

    public Livro busca_livro(LivroService livroService, int opcoes){
        switch(opcoes){
            case 1 -> {
                String id;
                System.out.print("ID: ");
                id = sc.nextLine();
                return livroService.buscar_id(id);
            }
            case 2 -> {
                String titulo;
                System.out.print("Titulo: ");
                titulo = sc.nextLine();
                return livroService.buscar_titulo(titulo);
            }
            default -> {
                return null;
            }
        }
    }

}
