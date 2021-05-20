package autor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autor")
public class AutorController {
	
	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	public ResponseEntity<AutorRequest> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {
		autorRepository.save(autorRequest.toModel());
		return ResponseEntity.ok().build();
	}
}
