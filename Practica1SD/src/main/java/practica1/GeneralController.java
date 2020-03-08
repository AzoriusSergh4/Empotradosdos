package practica1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import practica1.author.Author;
import practica1.author.AuthorRepository;
import practica1.client.Client;
import practica1.client.ClientRepository;
import practica1.picture.Picture;
import practica1.picture.PictureRepository;
import practica1.picture.soldPicture.SoldPicture;
import practica1.picture.soldPicture.SoldPictureRepository;

import javax.annotation.PostConstruct;
import java.sql.Date;

@Controller
public class GeneralController {

    @Autowired
    private SoldPictureRepository soldPictureRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostConstruct
    public void init() {
        Author author = new Author("José", "Pérez", "22222222J", 1972, "Ecuador",
                "Av. 6 de Diciembre, Quito 170505, Ecuador", "pintorjoseperez@gmail.com", "5932498124");
        authorRepository.save(author);

        Client buyer = new Client("Fernado", "López", "11111111H", "Calle Tulipán, s/n, 28933 Móstoles, Madrid",
                "compradorfernandolopez@gmail.com", "678912354");
        clientRepository.save(buyer);

        Picture cuadro = new SoldPicture("Bacon", "Un cuadro de un crujiente bacon frito",
                2017, 30.52, 26.88, 3000, author, buyer, new Date(12/01/2020));
        pictureRepository.save(cuadro);
        
        Picture cuadro2 = new Picture("Cerdo", "Cerdo sin bacon", 2016, 41.43, 23.45, 1000, author);
        pictureRepository.save(cuadro2);
    }
}
