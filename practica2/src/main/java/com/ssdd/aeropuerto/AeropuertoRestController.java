package com.ssdd.aeropuerto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/aeropuertos")
@RestController
public class AeropuertoRestController {

	@Autowired
	AeropuertoRepository aeropuertoRepository;

	/**
	 * Lista todos los aeropuertos 
	 * 
	 * @return la lista de aeropuertos
	 */
	@CrossOrigin
	@RequestMapping("/")
	public List<Aeropuerto> listAeropuertos() {
		return aeropuertoRepository.findAll();
	}
	
	/**
	 * Devuelve los nombres de los aeropuertos, usado para el Autocomplete
	 * @return la listan de nombres
	 */
	@CrossOrigin
	@RequestMapping("/nombres")
	public List<String> listNombresAeropuertos() {
		List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
		ArrayList<String> lista = new ArrayList<>();
		for(Aeropuerto a : aeropuertos) {
			lista.add(a.getNombre());
		}
		return lista;
	}
}
