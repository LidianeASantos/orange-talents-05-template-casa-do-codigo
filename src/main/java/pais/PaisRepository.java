package pais;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import estado.Estado;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

	 @Query("SELECT e FROM Estado e, Pais p WHERE e.nome = :nome AND p.id = :idPais "
	            + "AND e.pais = p " )
	    List<Estado> findByNomePais(String nome, Long idPais);

}
