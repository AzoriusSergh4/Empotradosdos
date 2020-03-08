package practica1.picture.soldPicture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/soldPicture")
public class SoldPictureController {
    @Autowired
    private SoldPictureRepository soldPictureRepository;

    @PostMapping("/")
    public void addSoldPicture(@RequestBody SoldPicture soldPicture) {
        this.soldPictureRepository.save(soldPicture);
    }
}
