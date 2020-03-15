package practica1.cuadro;

import java.sql.Date;
import java.util.List;

import practica1.autor.Autor;
import practica1.cliente.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {

	List<Cuadro> findByTituloContainsIgnoreCase(String titulo);
	List<Cuadro> findByAutor(Autor autor);
	List<Cuadro> findByAnyoFinalizacion(int anyoFinalizacion);
	List<Cuadro> findByFechaVenta(Date fechaVenta);
	List<Cuadro> findByComprador(Cliente comprador);

	List<Cuadro> findAllOrderByTitulo(String titulo);
	List<Cuadro> findAllOrderByAutor(Autor autor);
	List<Cuadro> findAllOrderByAnyoFinalizacion(int anyoFinalizacion);
	List<Cuadro> findAllOrderByFechaVenta(Date fechaVenta);
	List<Cuadro> findAllOrderByComprador(Cliente comprador);
	
	
}
