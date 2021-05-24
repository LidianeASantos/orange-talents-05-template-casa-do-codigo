package estado;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pais.PaisRepository;

@RestController
@RequestMapping ("/ estados")
public class EstadoController {

	 	@Autowired
	    EstadoRepository estadoRepository;

	    @Autowired
	    PaisRepository paisRepository;

	    @PostMapping
	    @Transactional
	    public ResponseEntity cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
	        Estado estado = estadoRequest.converter(paisRepository, estadoRepository);
	        if (estado == null) {
	            return ResponseEntity.notFound().build();
	        } estadoRepository.save(estado);
	        return ResponseEntity.ok().build();
	    }
}
