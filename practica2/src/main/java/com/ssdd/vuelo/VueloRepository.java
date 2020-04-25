package com.ssdd.vuelo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VueloRepository extends JpaRepository<Vuelo, Long> { 

	List<Vuelo> findByOrigenNombreContainingIgnoreCase(String nombre);
}
