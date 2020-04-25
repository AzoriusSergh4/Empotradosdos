package com.ssdd;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssdd.aeropuerto.Aeropuerto;
import com.ssdd.aeropuerto.AeropuertoRepository;

@Controller
public class GeneralController {
	
	@Autowired
	AeropuertoRepository aeropuertoRepository;
	
	/**
	 * Método que inicializa los datos en la base de datos
	 */
	  @PostConstruct
	    public void init() {
		  
		  //Creación de aeropuertos
	    	Aeropuerto a1 = new Aeropuerto("AAAA", "Madrid Barajas Adolfo Suárez");
	    	Aeropuerto a2 = new Aeropuerto("BBBB", "Barcelona Josep Tarradellas");
	    	Aeropuerto a3 = new Aeropuerto("CCCC", "Valencia Manises");
	    	aeropuertoRepository.save(a1);
	    	aeropuertoRepository.save(a2);
	    	aeropuertoRepository.save(a3);
	    }
	

	@GetMapping("/")
	public String getPage(Model model) {
		return "index";
	}
}
