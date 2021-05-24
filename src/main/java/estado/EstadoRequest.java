package estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import pais.Pais;
import pais.PaisRepository;
import validarErros.ErroValidacao.ExistsId;

public class EstadoRequest {

	 	@NotBlank
	    private String nome;

	    @NotNull
	    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Identificador de país não informado")
	    private Long paisId;


	    public EstadoRequest(String nome, Long paisId) {
	        this.nome = nome;
	        this.paisId = paisId;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public Long getPaisId() {
	        return paisId;
	    }

	    public Estado converter(PaisRepository paisRepository, EstadoRepository estadoRepository){
	        Pais pais = paisRepository.getOne(paisId);  //busca o país no banco de dados, pelo id informado
	        if(pais != null) {
	            return new Estado(nome, pais);  //retorna o estado e o país
	        }
	        return null;    //se não for encontrado, retorna nulo
	    }
}
