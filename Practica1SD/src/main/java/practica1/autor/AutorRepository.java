package practica1.autor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
	List<Autor> findDistinctAutorByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String apellidos);
	Autor findByNif(String nif);
}
