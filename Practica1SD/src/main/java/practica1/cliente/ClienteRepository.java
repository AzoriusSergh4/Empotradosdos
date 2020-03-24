package practica1.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findDistinctClienteByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(String nombre, String apellidos);
	Cliente findByNif(String nif);
}
