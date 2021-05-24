package pais;

import javax.validation.constraints.NotBlank;

import Validacoes.UniqueValue;

public class PaisRequest {

	 	@NotBlank
	   	@UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "O país informado já existe")
	    private String nome;

	 	public PaisRequest(String nome) {
	        this.nome = nome;
	    }

	    public PaisRequest() {
	    }
	 	
	    public String getNome() { return nome; }

	    public Pais converter() {
	        return new Pais(this.nome);
	    }
}
