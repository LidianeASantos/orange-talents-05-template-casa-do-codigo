package pais;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paises")
public class PaisController {

	 	@Autowired
	    PaisRepository paisRepository;

	    @PostMapping
	    @Transactional
	    public ResponseEntity cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
	        Pais pais = paisRequest.converter();
	        paisRepository.save(pais);

	        return ResponseEntity.ok().build();
	    }
}
