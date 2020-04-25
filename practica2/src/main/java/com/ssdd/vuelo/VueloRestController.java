package com.ssdd.vuelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/vuelos")
@RestController
public class VueloRestController {
	
	@Autowired
	VueloRepository vueloRepository;
	
	@CrossOrigin
	@RequestMapping("/")
	public List<Vuelo> listVuelos(){
		return vueloRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping("/find")
	public List<Vuelo> findVuelos(@RequestParam String origen, @RequestParam String destino, @RequestParam String fechaSalida){
		SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha;
		try {
			fecha = new Date(parser.parse(fechaSalida).getTime());
			return vueloRepository.findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCaseAndFechaSalida(origen, destino, fecha);
		} catch (ParseException e) {
			return vueloRepository.findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCase(origen, destino);
		}
		
	}
	
}
