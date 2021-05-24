package livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import autor.Autor;
import categoria.Categoria;

@Entity
public class Livro {

	 	@Id 
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @NotBlank
	    private String titulo;
	    
	    @NotBlank
	    @Size(max = 500)
	    private String resumo;
	    
	    @NotBlank
	    private String sumario;
	    
	    @NotNull @Min(20)
	    private BigDecimal preco;
	    
	    @Min(100)
	    private int quantidadePaginas;
	    
	    @NotBlank
	    private String isbn;
	    
	    @Future
	    private LocalDate dataPublicacao;
	    
	    @NotNull
	    @ManyToOne
	    @Valid
	    private Autor autor;
	    
	    @NotNull
	    @ManyToOne
	    @Valid
	    private Categoria categoria;
	    

	    @Deprecated
	    public Livro() {

	    }

	    public Livro(String titulo, String resumo, String sumario,
	                 BigDecimal preco, int quantidadePaginas,
	                 String isbn, LocalDate dataPublicacao,
	                 Autor autor, Categoria categoria) {

	        this.titulo = titulo;
	        this.resumo = resumo;
	        this.sumario = sumario;
	        this.preco = preco;
	        this.quantidadePaginas = quantidadePaginas;
	        this.isbn = isbn;
	        this.dataPublicacao = dataPublicacao;
	        this.autor = autor;
	        this.categoria = categoria;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public String getResumo() {
	        return resumo;
	    }

	    public String getSumario() {
	        return sumario;
	    }

	    public BigDecimal getPreco() {
	        return preco;
	    }

	    public int getQuantidadePaginas() {
	        return quantidadePaginas;
	    }

	    public String getIsbn() {
	        return isbn;
	    }

	    public LocalDate getDataPublicacao() {
	        return dataPublicacao;
	    }

	    public Autor getAutor() {
	        return autor;
	    }

	    public Categoria getCategoria() {
	        return categoria;
	    }
	    
	    public Long getId() { return id; }

	    	    }

