package com.ssdd.vuelo;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	public List<VueloResult> findVuelos(@RequestParam String origen, @RequestParam String destino, @RequestParam String fechaSalida){
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIda;
		List<Vuelo> vuelos = new ArrayList<>();
		try {
			fechaIda = new Date(parser.parse(fechaSalida).getTime());
			vuelos =  vueloRepository.findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCaseAndFechaSalida(origen, destino, fechaIda);
			
		} catch (ParseException e) {
			vuelos =  vueloRepository.findByOrigenNombreContainingIgnoreCaseAndDestinoNombreContainingIgnoreCase(origen, destino);
		}
		List<VueloResult> lista = new ArrayList<VueloResult>();
		for(Vuelo v : vuelos) {
			//TODO vuelos de vuelta
			lista.add(new VueloResult(v, null));
			
		}
		return lista;
		
	}
	
}
