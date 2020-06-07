package com.ssdd.vuelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de métodos relacionados con vuelos
 * @author Sergio Lira Díaz, Sara Rodríguez Alarcón
 *
 */
public interface VueloRepository extends JpaRepository<Vuelo, Long> { 

	/**
	 * Filtra los vuelos por origen, destino y fecha de salida
	 * @param origen el aeropuerto origen
	 * @param destino el aeropuerto destino
	 * @param fechaSalida la fecha de salida
	 * @return la lista de aeropuertos que cumplen los criterios
	 */
	List<Vuelo> findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCaseAndFechaSalida(String origen, String destino, Date fechaSalida);

	/**
	 * Filtra los vuelos por origen y destino
	 * @param origen el aeropuerto origen
	 * @param destino el aeropuerto destino
	 * @return la lista de aeropuertos que cumplen los criterios
	 */
	List<Vuelo> findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCase(String origen, String destino);
}
