package practica1.cuadro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cuadro")
public class CuadroController {
    @Autowired
    private CuadroRepository cuadroRepository;

    @PostMapping("/")
    public String addCuadro(@RequestBody Cuadro cuadro) {
        this.cuadroRepository.save(cuadro);

        return "galeria";
    }
}
