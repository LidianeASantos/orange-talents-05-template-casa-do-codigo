package autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Long> {

	Optional<Autor> findByEmail(String email);
	
}
