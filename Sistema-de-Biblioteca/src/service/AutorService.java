package service;

import model.Autor;
import repository.AutorRepository;
import util.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AutorService {
    Util util = new Util();
    Scanner sc = new Scanner(System.in);
    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository){
        this.autorRepository = autorRepository;
    }

    public Autor cadastrar_autor(String nome, String dataNascimentoS){
        String id;
        do {
            id = util.idGenerator();
        } while(util.sameAuthorId(autorRepository, id));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data;
        try{
            data = LocalDate.parse(dataNascimentoS, formatter);
        } catch (Exception ex) {
            System.out.println("Data invalida. Tente novamente.\n");
            while(true){
                try{
                    System.out.print("Nascimento do autor(dd/mm/yyyy): ");
                    dataNascimentoS = sc.nextLine();
                    data = LocalDate.parse(dataNascimentoS, formatter);
                    break;
                } catch(Exception e){
                    System.out.println("Data invalida. Tente novamente.\n");
                }
            }
        }
        Autor novoAutor = new Autor(id, nome, data);
        autorRepository.salvar(novoAutor);
        return novoAutor;
    }

    public void remover_autor(String id){
        Autor autor = autorRepository.buscar(id);
        autorRepository.deletar(autor);
    }


}
