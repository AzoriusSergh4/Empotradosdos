package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import practica1.autor.Autor;
import practica1.autor.AutorRepository;
import practica1.cliente.Cliente;
import practica1.cliente.ClienteRepository;
import practica1.cuadro.Cuadro;
import practica1.cuadro.CuadroRepository;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class GeneralController extends GaleriaController{

    @Autowired
    private CuadroRepository cuadroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private AutorRepository autorRepository;

    @PostConstruct
    public void init() {
    	try {
    	
    		SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
    	
	        Autor autor = new Autor("José", "Pérez", "22222222J", 1972, "Ecuador",
	                "Av. 6 de Diciembre, Quito 170505, Ecuador", "pintorjoseperez@gmail.com", "5932498124");
	        autorRepository.save(autor);
	        
	        Autor autor2 = new Autor("Cristian", "Gálvez", "12345678F", 1945, "Panamá", "Calle Julieta 45, Ciudad de Panamá 23456, Panamá", "cgalvez@hotmail.com", "666777888");
	        autorRepository.save(autor2);
	        
	        Autor autor3 = new Autor("Esteban", "Martinez", "43263954C", 1974, "España", "Calle Pintor Velázquez 32, Barcelona 34213, España", "estemart@gmail.com", "654812305");
	        autorRepository.save(autor3);
	
	        Cliente comprador = new Cliente("Fernando", "López", "11111111H", "Calle Tulipán, s/n, 28933 Móstoles, Madrid",
	                "compradorfernandolopez@gmail.com", "678912354");
	        clienteRepository.save(comprador);
	        
	        Cliente cliente2 = new Cliente("Carmen", "Lozano", "22222222D", "Calle Flamenco, 34, 28609 Villamantilla, Madrid", "carmenarte@hotmail.com", "678888973");
	        clienteRepository.save(cliente2);
	        
	        Cuadro cuadro = new Cuadro("Bacon", "Un cuadro de un crujiente bacon frito",
				        2017, 30.52, 26.88, 3000, autor, comprador, new Date(fecha.parse("12/01/2020").getTime()));
			
	        cuadroRepository.save(cuadro);
	        
	        Cuadro cuadro2 = new Cuadro("Cerdo", "Cerdo sin bacon", 2016, 41.43, 23.45, 1000, autor, null, null);
	        cuadroRepository.save(cuadro2);
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @GetMapping("/")
    public String getGalleryInfo(Model model) {

    	cargaGaleria(model);

        return "galeria";
    }

}
