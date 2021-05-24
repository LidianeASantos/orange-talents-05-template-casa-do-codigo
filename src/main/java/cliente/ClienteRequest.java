package cliente;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import Validacoes.CPFouCNPJ;
import Validacoes.UniqueValue;
import estado.Estado;
import estado.EstadoRepository;
import pais.Pais;
import pais.PaisRepository;
import validarErros.ErroValidacao.ExistsId;

public class ClienteRequest {

	@NotBlank
    @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email", message = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;

    @CPFouCNPJ
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotBlank
    private String cep;
    @NotBlank
    private String telefone;

    private Long estadoId;

    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Identificador de país não informado")
    private Long paisId;


    public ClienteRequest(String email, String nome,
                          String sobrenome, String documento,
                          String endereco, String complemento,
                          String cidade, String cep,
                          String telefone, Long paisId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;
        this.telefone = telefone;
        this.paisId = paisId;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> pais = paisRepository.findById(paisId);
        if (pais.isEmpty()) {
            throw new IllegalStateException("País não encontrado");
        }

        Cliente cliente = new Cliente(email, nome, sobrenome, documento, endereco, complemento, cidade, cep, telefone, pais.get());
        if (estadoId != null) {
            Optional<Estado> estado = estadoRepository.findById(estadoId);
            if (estado.isEmpty()) {
                throw new IllegalStateException("Estado não encontrado");
            }
            cliente.setEstado(estado.get());
        }
        return cliente;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public Long getPaisId() { return paisId;
    }
    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

}
