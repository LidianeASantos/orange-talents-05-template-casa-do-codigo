package categoria;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ValidaNomeCategoria implements Validator {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaRequest.class.isAssignableFrom(clazz);
	}

	 @Override
	 public void validate(Object target, Errors errors){
	       if(errors.hasErrors()){
	        }

	
		CategoriaRequest categoriaRequest = (CategoriaRequest) target;
		
		Optional<Categoria> autorOP = categoriaRepository.findByNome(categoriaRequest.getNome());
			if(autorOP.isPresent()){
				errors.rejectValue("nome", null, "Essa categoria já existe");
				System.out.println("Essa categoria já existe");
	}
	
	}
}
