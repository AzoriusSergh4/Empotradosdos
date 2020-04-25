package com.ssdd;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssdd.aeropuerto.Aeropuerto;
import com.ssdd.aeropuerto.AeropuertoRepository;
import com.ssdd.vuelo.Vuelo;

@Controller
public class GeneralController {
	
	@Autowired
	AeropuertoRepository aeropuertoRepository;
	
	/**
	 * Método que inicializa los datos en la base de datos
	 */
	  @PostConstruct
	    public void init() {
		  try {
		    	
	    	SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
	    	//Creación de aeropuertos
	    	Aeropuerto a1 = new Aeropuerto("AAAA", "Madrid Barajas Adolfo Suárez");
	    	Aeropuerto a2 = new Aeropuerto("BBBB", "Barcelona Josep Tarradellas");
	    	Aeropuerto a3 = new Aeropuerto("CCCC", "Valencia Manises");
	    	aeropuertoRepository.save(a1);
	    	aeropuertoRepository.save(a2);
	    	aeropuertoRepository.save(a3);
	    	
	    	
	    	//Creación de vuelos
	    	Vuelo v1 = new Vuelo("EW1234", new Date(fecha.parse("12/01/2020").getTime()), 240, 345, a1, a2);
		  } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	

	@GetMapping("/")
	public String getPage(Model model) {
		return "index";
	}
}
