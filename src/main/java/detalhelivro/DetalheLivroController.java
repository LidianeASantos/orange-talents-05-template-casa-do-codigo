package detalhelivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RestController;

import livro.Livro;

@RestController
public class DetalheLivroController {

	 String titulo;
	    private String resumo;
	    private String sumario;
	    private BigDecimal preco;
	    private int quantidadePaginas;
	    private String isbn;
	    private String dataPublicacao;
	    private DetalheLivroController detalheLivroController;


	    public DetalheLivroController(Livro livro) {   //recebe um tipo Livro como argumento para buscar no banco as informações
	        this.titulo = livro.getTitulo();
	        this.resumo = livro.getResumo();
	        this.sumario = livro.getSumario();
	        this.preco = livro.getPreco();
	        this.quantidadePaginas = livro.getQuantidadePaginas();
	        this.isbn = livro.getIsbn();
	        this.dataPublicacao = livro.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        this.detalheLivroController = new DetalheLivroController(((Livro) livro).getLivro());   //busca as informações no DetalhaAutor
	    }
	
}
