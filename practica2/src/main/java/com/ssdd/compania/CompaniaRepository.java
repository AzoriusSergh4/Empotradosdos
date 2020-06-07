package com.ssdd.compania;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de métodos relacionados con compañías
 * @author Sergio Lira Díaz, Sara Rodríguez Alarcón
 *
 */
public interface CompaniaRepository extends JpaRepository<Compania, Long> { 
	/**
	 * Filtra compañías por código o nombre
	 * @param codigo código de compañía
	 * @param nombre nombre de compañía
	 * @return la lista de compañías que cumplen los criterios
	 */
	List<Compania> findByCodigoContainsIgnoreCaseOrNombreContainsIgnoreCase(String codigo,String nombre);
	
}
