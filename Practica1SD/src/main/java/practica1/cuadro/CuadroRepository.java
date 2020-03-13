package practica1.cuadro;

import org.springframework.data.jpa.repository.JpaRepository;

import practica1.autor.Autor;

import java.util.List;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {
    Cuadro findByTitulo(String titulo);
    List<Cuadro> findByTituloAndAutor(String titulo, Autor autor);
}
