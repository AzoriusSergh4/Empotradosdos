package practica1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConsultController {
	
	@Autowired
	private GaleriaRepository repGaleria;

	@RequestMapping("/consult")
	public String mostrar(@RequestParam String title, @RequestParam Autor author, Model model) {

		List<Cuadro> varioscuadros = repGaleria.findByTitleAndAuthor(title, author);

		model.addAttribute("cuadros", varioscuadros);

		return "consult";
	}

}
