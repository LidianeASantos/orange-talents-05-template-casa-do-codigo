package livro;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import categoria.CategoriaRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

	 @Autowired
	 CategoriaRepository categoriaRepository;
	
	@PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity cria(@RequestBody @Valid LivroRequest livroRequest) {
        Livro livro = livroRequest.converte(manager);
       manager.persist(livro);

        return ResponseEntity.ok().build();
    }
    
   
    }
