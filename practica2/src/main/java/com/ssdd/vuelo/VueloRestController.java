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
	public List<VueloResult> findVuelos(@RequestParam String origen, @RequestParam String destino, @RequestParam String fechaSalida, @RequestParam String fechaSalidaVuelta){
		SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaIda;
		Date fechaVuelta;
		List<Vuelo> vuelosIda = new ArrayList<>();
		List<Vuelo> vuelosVuelta = new ArrayList<>();
		try {
			fechaIda = new Date(parser.parse(fechaSalida).getTime());
			vuelosIda =  vueloRepository.findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCaseAndFechaSalida(origen, destino, fechaIda);
			
		} catch (ParseException e) {
			vuelosIda =  vueloRepository.findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCase(origen, destino);
		}
		try {
			fechaVuelta = new Date(parser.parse(fechaSalidaVuelta).getTime());
			vuelosVuelta =  vueloRepository.findByOrigenContainingIgnoreCaseAndDestinoContainingIgnoreCaseAndFechaSalida(destino, origen, fechaVuelta);
			
		} catch (ParseException e) {
			vuelosVuelta =  null;
		}
		List<VueloResult> lista = new ArrayList<VueloResult>();
		for(Vuelo v : vuelosIda) {
			if (vuelosVuelta != null) {
				for(Vuelo v2 : vuelosVuelta) {
					if ( (v.getFechaSalida().before(v2.getFechaSalida())) || 
							(v.getFechaSalida().equals(v2.getFechaSalida()) && (v.getHoraSalida().before(v2.getHoraSalida())) && (!v.getHoraSalida().equals(v2.getHoraSalida()))) ) {
			 
							lista.add(new VueloResult(v, v2));
						
					}
				}
					
			} 
			else {
				lista.add(new VueloResult(v, null));
			}
		}
		
		return lista;
		
	}
	
}
