package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import practica1.cuadro.CuadroRepository;

@Controller
public class GaleriaController {
	 @Autowired
	   private CuadroRepository cuadroRepository;

	   @RequestMapping("/")
	   public String tablon(Model model) {
				
	      model.addAttribute("cuadros", cuadroRepository.findAll());

	      return "galeria";
	   }

}
