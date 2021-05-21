package categoria;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
	
	@NotBlank
    private String nome;

    public Categoria converter(){
        return new Categoria(this.nome);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "CategoriaRequest{" +
                "nome='" + nome + '\'' +
                '}';
    }
	
}
