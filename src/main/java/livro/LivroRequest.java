package livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import Validacoes.UniqueValue;
import autor.Autor;
import categoria.Categoria;



public class LivroRequest {

	 	@NotBlank
	    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	    private String titulo;
	 	
	    @NotBlank
	    @Size(max = 500)
	    private String resumo;
	    
	    @NotBlank
	    private String sumario;
	    
	    @NotNull
	    @Min(20)
	    private BigDecimal preco;
	    
	    @Min(100)
	    private int quantidadePaginas;
	    

	    @NotBlank
	    @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	    private String isbn;

	    @Future
	    @NotNull
	    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	    private LocalDate dataPublicacao;

	    @NotNull
	    private Long autorId;

	    @NotNull
	    @ManyToOne    
	    private Long categoriaId;

	    public LivroRequest(String titulo, String resumo, String sumario,
	                        BigDecimal preco, int quantidadePaginas,
	                        String isbn,
	                        Long autorId, Long categoriaId) {
	        this.titulo = titulo;
	        this.resumo = resumo;
	        this.sumario = sumario;
	        this.preco = preco;
	        this.quantidadePaginas = quantidadePaginas;
	        this.isbn = isbn;
	        this.autorId = autorId;
	        this.categoriaId = categoriaId;
	    }

	    public void setDataPublicacao(LocalDate dataPublicacao) {
	        this.dataPublicacao = dataPublicacao;
	    }

	    public Livro converte(EntityManager manager) {
	        Autor autor = manager.find(Autor.class, autorId);
	        Categoria categoria =manager.find(Categoria.class, categoriaId);
	        return new Livro(titulo, resumo, sumario, preco, quantidadePaginas,
	                isbn, dataPublicacao, autor, categoria);
	    }
}
