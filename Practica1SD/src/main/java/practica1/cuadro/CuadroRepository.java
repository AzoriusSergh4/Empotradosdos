package practica1.cuadro;

import java.util.List;

import org.springframework.stereotype.Repository;
import practica1.autor.Autor;
import practica1.cliente.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	List<Cuadro> findDistinctCuadroByTituloContainsIgnoreCaseOrDescripcionContainsIgnoreCase(String titulo, String descripcion);
	List<Cuadro> findByAutor(Autor autor);

}
