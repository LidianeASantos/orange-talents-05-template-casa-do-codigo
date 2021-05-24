package livro;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;

public class LivroDto {

    private Long id;
    private String titulo;

    public LivroDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() { return id; }

    public String getTitulo() { return titulo; }


    public static List<LivroDto> converter(List<Livro> lista) {
        List<LivroDto>  livrosDto = lista.stream()
                                        .map((livro) -> new LivroDto(livro.getId(), livro.getTitulo()))
                                        .collect(Collectors.toList());
       return livrosDto;
    }
}
    
