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
    	
	        Autor autor1 = new Autor("José", "Pérez", "22222222J", 1972, "Ecuador", "Av. 6 de Diciembre, Quito 170505, Ecuador", "pintorjoseperez@gmail.com", "5932498124");
	        autorRepository.save(autor1);
	        
	        Autor autor2 = new Autor("Cristian", "Gálvez", "12345678F", 1945, "Panamá", "Calle Julieta 45, Ciudad de Panamá 23456, Panamá", "cgalvez@hotmail.com", "666777888");
	        autorRepository.save(autor2);
	        
	        Autor autor3 = new Autor("Esteban", "Martinez", "43263954C", 1974, "España", "Calle Pintor Velázquez 32, Madrid 28933, España", "estemart@gmail.com", "654812305");
	        autorRepository.save(autor3);
	        
	        Autor autor4 = new Autor("Víctor", "Montes", "10203040V", 1953, "Chile", "Avenida Luis Gil 55, Santiago 14051, Chile", "vmontes@gmail.com", "56995955129");
	        autorRepository.save(autor4);
	        
	        Autor autor5 = new Autor("Ainhoa", "Rodríguez", "50607080A", 1988, "España", "Calle de Gaztambide, 56, 28015 Madrid", "ainoaroar@gmail.com", "672032344");
	        autorRepository.save(autor5);
	        
	        Autor autor6 = new Autor("Naiara", "Moreno", "90112131N", 1990, "Argentina", "Avenida Méndez de Andes 140, C1405 CVT, Buenos Aires, Argentina", "naiara.moreno.hernandez@gmail.com", "541120105076");
	        autorRepository.save(autor6);
	        
	        Autor autor7 = new Autor("Ainara", "Jiménez", "41516171M", 1965, "España", "Sabino Arana Etorbidea, 14, 48013 Bilbao, España", "ainara.anara@gmail.com", "944345544");
	        autorRepository.save(autor7);
	        
	        Autor autor8 = new Autor("Andrea", "Pérez", "81911223P", 1984, "Colombia", "Calle 25 B Nº 69 C-80, Bogotá, Cundinamarca, Colombia", "a.perez@gmail.com", "5712105000");
	        autorRepository.save(autor8);
	        
	        
	        
	        Cliente cliente1 = new Cliente("Fernando", "López", "11111111H", "Calle Tulipán, s/n, 28933 Móstoles, Madrid", "compradorfernandolopez@gmail.com", "678912354");
	        clienteRepository.save(cliente1);
	        
	        Cliente cliente2 = new Cliente("Carmen", "Lozano", "22222222D", "Calle Flamenco, 34, 28609 Villamantilla, Madrid", "carmenarte@hotmail.com", "678888973");
	        clienteRepository.save(cliente2);
	        
	        Cliente cliente3 = new Cliente("Roque", "Santos", "33333333S", "Calle de los Mártires, 22, 28607 El Álamo, Madrid", "roquesantos@hotmail.com", "648280613");
	        clienteRepository.save(cliente3);
	        
	        Cliente cliente4 = new Cliente("Néstor", "López", "44444444L", "Ronda de San Juan, 15, 28600 Navalcarnero, Madrid", "nestorlopez@hotmail.com", "661381779");
	        clienteRepository.save(cliente4);
	        
	        Cliente cliente5 = new Cliente("Diego", "Rivas", "55555555R", "Calle Doña Filomena, 10, 28991 Torrejón de la Calzada, Madrid", "diegorivas@hotmail.com", "606573517");
	        clienteRepository.save(cliente5);
	        
	        Cliente cliente6 = new Cliente("Rebeca", "Ortiz", "66666666Z", "Calle Dr. García Torres, 3, 28609 Sevilla la Nueva, Madrid", "rebe_ortiz@hotmail.com", "918124131");
	        clienteRepository.save(cliente6);
	        
	        Cliente cliente7 = new Cliente("Paola", "Cuesta", "77777777W", "Av. de Elvas, s/n, 06080 Badajoz", "paolacuesta@hotmail.com", "924218100");
	        clienteRepository.save(cliente7);
	        
	        Cliente cliente8 = new Cliente("Natalia", "Ballesteros", "88888888B", "Travesía De Móstoles N°3, 28921 Alcorcón, Madrid", "natyballesteros@hotmail.com", "916144126");
	        clienteRepository.save(cliente8);
	        
	        
	        
	        Cuadro cuadro1 = new Cuadro("Bacon", "Un cuadro de un crujiente bacon frito", 2017, 30.52, 26.88, 3000, autor1, cliente1, new Date(fecha.parse("12/01/2020").getTime()));	
	        cuadroRepository.save(cuadro1);
	        
	        Cuadro cuadro2 = new Cuadro("Cerdo", "Cerdo sin bacon", 2016, 41.43, 23.45, 1000, autor6, null, null);
	        cuadroRepository.save(cuadro2);
	        
	        Cuadro cuadro3 = new Cuadro("La Granja", "Hermosa granja del siglo XIV pintada sobre óleo", 2015, 33.80, 25.30, 1500, autor6, cliente6, new Date(fecha.parse("24/08/2019").getTime()));	
	        cuadroRepository.save(cuadro3);
	        
	        Cuadro cuadro4 = new Cuadro("Océano", "Majestuoso cuadro sobre la profundidad del Océano Pacífico. No apto para personas que padezcan talasofobia", 2010, 200.52, 80.88, 10000, autor4, cliente8, new Date(fecha.parse("07/05/2013").getTime()));	
	        cuadroRepository.save(cuadro4);
	        
	        Cuadro cuadro5 = new Cuadro("Troyano", "Cuadro sobre el famoso caballo de Troya en un estilo moderno e innovador", 2014, 15.90, 10.66, 500, autor7, cliente7, new Date(fecha.parse("23/12/2016").getTime()));	
	        cuadroRepository.save(cuadro5);
	        
	        Cuadro cuadro6 = new Cuadro("Luz en la oscuridad", "Soledad representada a través de una oscura noche sin estrellas y una única farola encendida", 2000 , 100.52, 45.78, 3600, autor3, cliente2, new Date(fecha.parse("10/03/2003").getTime()));	
	        cuadroRepository.save(cuadro6);
	        
	        Cuadro cuadro7 = new Cuadro("Soldadito Marinero", "Cuadro sobre un soldado que también quiso ser niño pero le pilló la guerra", 2004, 70.01, 35.06, 1290, autor2, cliente6, new Date(fecha.parse("22/04/2010").getTime()));	
	        cuadroRepository.save(cuadro7);
	        
	        Cuadro cuadro8 = new Cuadro("Lady Madrid", "En este cuadro se puede una estrella sobre los tejados madrileños del barrio de Chamberí", 1996, 20.30, 10.77, 990, autor3, cliente3, new Date(fecha.parse("08/09/2009").getTime()));	
	        cuadroRepository.save(cuadro8);
	        
	        Cuadro cuadro9 = new Cuadro("Lunares", "Un cuadro sobre unos amigos en una fiesta de Ibiza", 2018, 20.14, 12.66, 150, autor8, cliente5, new Date(fecha.parse("15/07/2019").getTime()));	
	        cuadroRepository.save(cuadro9);
	         
	        Cuadro cuadro10 = new Cuadro("El Parisino", "El Parisino es un cuadro en el que se refleja el verdadero significado de 'amor eterno'", 1996, 10.10, 10.11, 1110, autor5, cliente4, new Date(fecha.parse("10/11/2014").getTime()));	
	        cuadroRepository.save(cuadro10);
	        
	        
	        
	        
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
