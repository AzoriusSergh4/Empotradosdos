package com.ssdd.vuelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VueloRepository extends JpaRepository<Vuelo, Long> { 

	List<Vuelo> findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCaseAndFechaSalida(String origen, String destino, Date fechaSalida);

	List<Vuelo> findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCase(String origen, String destino);
}
