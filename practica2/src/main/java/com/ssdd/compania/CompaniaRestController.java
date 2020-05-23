package com.ssdd.compania;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RequestMapping("/companias")
@RestController
public class CompaniaRestController {
	
	@Autowired
	CompaniaRepository companiaRepository;

	@CrossOrigin
	@RequestMapping("/")
	public List<Compania> listCompania() {
		return companiaRepository.findAll();
	}
	
	@CrossOrigin
	@RequestMapping("/compania")
	public Compania getCompania(@RequestParam String codigoONombre) {
		List<Compania> lista = companiaRepository.findByCodigoContainsIgnoreCaseOrNombreContainsIgnoreCase(codigoONombre, codigoONombre);
		return lista.get(0);
	}

}
