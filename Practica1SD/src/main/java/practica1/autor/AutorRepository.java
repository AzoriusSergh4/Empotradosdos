package practica1.autor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
	List<Autor> findDistinctAutorByNombreOrApellidosContainsIgnoreCase(String nombre, String apellidos);
	Autor findByNif(String nif);
	
	List<Autor> findAllOrderByNombre(String nombre);
	List<Autor> findAllOrderByApellidos(String apellidos);
	List<Autor> findAllOrderByEmail(String email);
	
}
