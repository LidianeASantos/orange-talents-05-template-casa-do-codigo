package pais;

import javax.validation.constraints.NotBlank;

import Validacoes.UniqueValue;

public class PaisRequest {

	 	@NotBlank
	    @UniqueValue(domainClass = Pais.class, fieldName =  "nome")
	    private String nome;

	    public String getNome() { return nome; }

	    public Pais converter() {
	        return new Pais(this.nome);
	    }
}
