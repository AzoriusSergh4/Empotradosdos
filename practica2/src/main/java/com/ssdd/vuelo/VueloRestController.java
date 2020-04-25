package com.ssdd.vuelo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vuelos")
@RestController
public class VueloRestController {
	
	@Autowired
	VueloRepository vueloRepository;
	
	@RequestMapping("/")
	public List<Vuelo> listVuelos(){
		return vueloRepository.findAll();
	}
	
	@RequestMapping("/find")
	public List<Vuelo> findVuelos(@RequestParam String nombre){
		return vueloRepository.findByOrigenNombreContainingIgnoreCase(nombre);
	}
	
}
