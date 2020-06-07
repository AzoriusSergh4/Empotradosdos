package com.ssdd.compania;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Controlador que administra los métodos relacionados con compañías
 * @author Sergio Lira Díaz, Sara Rodríguez Alarcón
 *
 */

@RequestMapping("/companias")
@RestController
public class CompaniaRestController {
	
	@Autowired
	CompaniaRepository companiaRepository;
	
	/**
	 * Devuelve todas las compañías
	 * @return la lista de compañías
	 */
	@CrossOrigin
	@RequestMapping("/")
	public List<Compania> listCompania() {
		return companiaRepository.findAll();
	}
	
	/**
	 * Devuelve la compañia dado un código o nombre
	 * @param codigoONombre el nombre o código de la compañía
	 * @return la compañía que cumple el criterio
	 */
	@CrossOrigin
	@RequestMapping("/compania")
	public Compania getCompania(@RequestParam String codigoONombre) {
		List<Compania> lista = companiaRepository.findByCodigoContainsIgnoreCaseOrNombreContainsIgnoreCase(codigoONombre, codigoONombre);
		return lista.get(0);
	}

}
