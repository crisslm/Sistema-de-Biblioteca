import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca{
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    
    public static void main(String [] args){
        try(Scanner sc = new Scanner(System.in)){
            
        }

    }

    public static int idGenerator(){
        Random random = new Random();
        int id = random.nextInt(999999); 
        return id;
    }
}
