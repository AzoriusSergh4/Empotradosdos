package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import practica1.autor.AutorRepository;
import practica1.cliente.ClienteRepository;
import practica1.cuadro.CuadroRepository;

@Controller
public class GaleriaController {
	
	@Autowired
    private CuadroRepository cuadroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutorRepository autorRepository;
	
	public void cargaGaleria(Model model) {
		model.addAttribute("cuadros", cuadroRepository.findAll());
        model.addAttribute("autores", autorRepository.findAll());
        model.addAttribute("clientes", clienteRepository.findAll());
	}
}
