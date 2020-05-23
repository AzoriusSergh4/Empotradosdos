package com.ssdd.compania;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CompaniaRepository extends JpaRepository<Compania, Long> { 
	List<Compania> findByCodigoContainsIgnoreCaseOrNombreContainsIgnoreCase(String codigo,String nombre);

}
