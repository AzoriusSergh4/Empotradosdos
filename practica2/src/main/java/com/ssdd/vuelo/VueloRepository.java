package com.ssdd.vuelo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VueloRepository extends JpaRepository<Vuelo, Long> { 

	List<Vuelo> findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCaseAndFechaSalida(String origen, String destino, Date fechaSalida);

	List<Vuelo> findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCase(String origen, String destino);
}
