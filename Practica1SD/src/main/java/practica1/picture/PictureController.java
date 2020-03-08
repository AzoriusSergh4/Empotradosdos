package practica1.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureRepository pictureRepository;

    @PostMapping("/")
    public String addPicture(@RequestBody Picture picture) {
        this.pictureRepository.save(picture);

        return "galeria";
    }
}
