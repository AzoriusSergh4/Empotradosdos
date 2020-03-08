package practica1;

import java.sql.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import practica1.author.Author;
import practica1.client.Client;
import practica1.picture.Picture;
import practica1.picture.PictureRepository;
import practica1.picture.soldPicture.SoldPicture;

@Controller
public class GalleryController {
	 @Autowired
	   private PictureRepository pictureRepository;
		
	   @PostConstruct
	   public void init() {
		   Author author = new Author("José", "Pérez", "22222222J", 1972, "Ecuador", "Av. 6 de Diciembre, Quito 170505, Ecuador", "pintorjoseperez@gmail.com", "5932498124");
		   Client buyer = new Client("Fernado", "López", "11111111H", "Calle Tulipán, s/n, 28933 Móstoles, Madrid", "compradorfernandolopez@gmail.com", "678912354");
		   Picture cuadro = new SoldPicture("Bacon", "Un cuadro de un crujiente bacon frito", 2017, 30.52, 26.88, 3000, author, buyer, new Date(12/01/2020));
		   pictureRepository.save(cuadro);
	   }
	   @RequestMapping("/")
	   public String tablon(Model model) {
				
	      model.addAttribute("cuadros", pictureRepository.findAll());

	      return "galeria";
	   }

}
