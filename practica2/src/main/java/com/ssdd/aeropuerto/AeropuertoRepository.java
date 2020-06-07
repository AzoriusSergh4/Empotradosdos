package com.ssdd.aeropuerto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de métodos relacionados con aeropuertos
 * @author Sergio Lira Díaz, Sara Rodríguez Alarcón
 *
 */
public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

	/**
	 * Filtra aeropuertos por nombre ignorando mayúsculas
	 * @param nombre nombnre de aeropuerto
	 * @return la lista de aeropuertos que cumple los criterios
	 */
	List<Aeropuerto> findByNombreContainsIgnoreCase(String nombre); 

	
	
}
