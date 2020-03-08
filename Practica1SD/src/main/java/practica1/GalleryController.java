package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import practica1.picture.PictureRepository;

@Controller
public class GalleryController {
	 @Autowired
	   private PictureRepository pictureRepository;

	   @RequestMapping("/")
	   public String tablon(Model model) {
				
	      model.addAttribute("cuadros", pictureRepository.findAll());

	      return "galeria";
	   }

}
