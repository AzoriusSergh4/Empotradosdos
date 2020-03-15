package practica1.cuadro;

import java.sql.Date;
import java.util.List;

import practica1.autor.Autor;
import practica1.cliente.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuadroRepository extends JpaRepository<Cuadro, Long> {
	
	Cuadro findByTituloContainsIgnoreCase(String titulo);
	Cuadro findByAutor(Autor autor);
	Cuadro findByAnyoFinalizacion(int anyoFinalizacion);
	Cuadro findByFechaVenta(Date fechaVenta);
	Cuadro findByComprador(Cliente comprador);

	List<Cuadro> findAllOrderByTitulo(String titulo);
	List<Cuadro> findAllOrderByAutor(Autor autor);
	List<Cuadro> findAllOrderByAnyoFinalizacion(int anyoFinalizacion);
	List<Cuadro> findAllOrderByFechaVenta(Date fechaVenta);
	List<Cuadro> findAllOrderByComprador(Cliente comprador);
	
	
}
