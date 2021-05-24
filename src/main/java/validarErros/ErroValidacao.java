package validarErros;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ErroValidacao {

	@Autowired
	private MessageSource messageSource;

	@ResponseBody
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class) 
	public String  handleHttpMediaTypeNotAcceptableException() {
		return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler( MethodArgumentNotValidException.class)
	public List<TratamentoErros> handle(MethodArgumentNotValidException exception) {
		List<TratamentoErros> request = new ArrayList<>();

		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			TratamentoErros erros = new TratamentoErros(e.getField(), mensagem);
			request.add(erros);
		});

		return request;
	}


	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler( HttpMessageNotReadableException.class)
	public String handle(HttpMessageNotReadableException exception) {

		return "Erro: HttpMessageNotReadableException: mensagem" + exception.getMessage()+ "|| "+
				exception.getHttpInputMessage();
	}

	@Documented
	@Constraint(validatedBy = {ExistsIdValidator.class})
	@Target({ElementType.FIELD})
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ExistsId {

	    String message() default "O identificador informado não existe";
	    Class<?>[] groups() default { };
	    Class<? extends Payload>[] payload() default { };
	    String fieldName();
	    Class<?> domainClass();
}
}
