package practica1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GaleriaRepository extends JpaRepository<Cuadro, Long>{

	Cuadro findByTitle(String nombre);
	List<Cuadro> findByTitleAndAuthor(String nombre, Autor autor);
}
