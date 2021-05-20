package autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

		
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 400)
	private String descricao;
	
		
	public Autor toModel() {
		return new Autor(this.nome, this.email, this.descricao);
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getDescricao() {
		return descricao;
	}
	
}
