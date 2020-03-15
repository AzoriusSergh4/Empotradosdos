package practica1.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNombreContainsIgnoreCase(String nombre);
	List<Cliente> findByApellidosContainsIgnoreCase(String apellidos);
	List<Cliente> findByEmailContainsIgnoreCase(String email);
	Cliente findByNif(String nif);
	
	List<Cliente> findAllOrderByNombre(String nombre);
	List<Cliente> findAllOrderByApellidos(String apellidos);
	List<Cliente> findAllOrderByEmail(String email);
}
