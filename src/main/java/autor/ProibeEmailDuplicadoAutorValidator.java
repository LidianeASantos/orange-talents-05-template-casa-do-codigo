package autor;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


	@Component 
	public class ProibeEmailDuplicadoAutorValidator implements Validator {

	@Autowired
	private AutorRepository autorRepository;
	
	public boolean supports(Class<?> clazz) {
		return AutorRequest.class.isAssignableFrom(clazz);
	}
	
	
	public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){ 
        	return; 
		}
		
		AutorRequest request = (AutorRequest) target;
		 Optional<Autor> autorOp = autorRepository.findByEmail(request.getEmail());
	        if(autorOp.isPresent()){
	            errors.rejectValue("email", null, "Já existe este email cadastrado na base de dados");
	            System.out.println("Já existe este email na base de dados");
	        }
	}
	}
	