package practica1;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GaleriaController {
	 @Autowired
	   private GaleriaRepository repGaleria;
		
	   @PostConstruct
	   public void init() {
		   repGaleria.save(new Cuadro("Bacon", "Un cuadro de un crujiente bacon frito", "2017", "30.52", "26.88", "3000", "José Perez", "Fernado López", "12/01/2020"));
	   }

	   @RequestMapping("/")
	   public String tablon(Model model) {
				
	      model.addAttribute("cuadros", repGaleria.findAll());

	      return "galeria";
	   }

}
