package com.ssdd.aeropuerto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface AeropuertoRepository extends JpaRepository<Aeropuerto, Long> {

	List<Aeropuerto> findByNombreContainsIgnoreCase(String nombre); 

	
	
}
