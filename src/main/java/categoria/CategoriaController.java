package categoria;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ValidaNomeCategoria categoriaDuplicaValidator;


    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators((Validator) categoriaDuplicaValidator);
    }

    @Transactional
    @PostMapping
    public ResponseEntity cria(@RequestBody @Valid CategoriaRequest categoriaDTO){
        Categoria categoria = categoriaDTO.converter();
        categoriaRepository.save(categoria);
        return ResponseEntity.ok().build();
    }
	}

