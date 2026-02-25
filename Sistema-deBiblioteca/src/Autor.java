
import java.time.LocalDate;

public class Autor {
    private String id;
    private Livro livro;
    private LocalDate dataNascimento;

    public Autor(String id, Livro livro, LocalDate dataNascimento){
        this.id = id;
        this.livro = livro;
        this.dataNascimento = dataNascimento;
    }

    //GETTERS
    public String getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }    
}
