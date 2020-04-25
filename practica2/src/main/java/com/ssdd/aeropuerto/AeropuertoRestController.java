package com.ssdd.aeropuerto;

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

	@CrossOrigin
	@RequestMapping("/")
	public List<Aeropuerto> listAeropuertos() {
		return aeropuertoRepository.findAll();
	}
}
