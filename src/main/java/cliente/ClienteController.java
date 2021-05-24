package cliente;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Validacoes.ValidaRestricaoEstadoPertencePais;
import estado.EstadoRepository;
import pais.PaisRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
    PaisRepository paisRepository;

    @Autowired
    EstadoRepository estadoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ValidaRestricaoEstadoPertencePais validaRestricaoEstadoPertencePais;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validaRestricaoEstadoPertencePais);
    }

    @PostMapping
    @Transactional
    public String salvar(@RequestBody @Valid ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
       clienteRepository.save(cliente);

        return cliente.toString();
    }
}
