package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AddController {
	@Autowired
	private GaleriaRepository repGaleria;

	@RequestMapping("/add")
	public String insertar(Cuadro cuadro, Model model) {

		repGaleria.save(cuadro);

		return "add";
	}

}
