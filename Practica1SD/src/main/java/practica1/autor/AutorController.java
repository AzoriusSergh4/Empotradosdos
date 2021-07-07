package practica1.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import practica1.GaleriaController;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/autor")
public class AutorController extends GaleriaController{

    @Autowired
    private AutorRepository autorRepository;
    
    @RequestMapping("/mostrarAutores")
    public String mostrarCuadros(Model model) {
        model.addAttribute("autores", autorRepository.findAll());
        return "autores";
    }

    @RequestMapping("/addAutor")
    public String addAutor(Model model) {
        return "nuevoAutor";
    }

    @PostMapping("/")
    public String addAutor(Model model, @RequestParam Map<String, String> mappedAutor) {
        Autor autor = this.crearAutorDesdeMap(mappedAutor);
        this.autorRepository.save(autor);
        model.addAttribute("autores", autorRepository.findAll());

        return "autores";
    }

    @RequestMapping("/editarAutor/{id}")
    public String editarAutor(Model model, @PathVariable long id) {
        Optional<Autor> opcional = this.autorRepository.findById(id);
        opcional.ifPresent(autor -> model.addAttribute("autor", autor));

        return "editarAutor";
    }

    @PostMapping("/{id}")
    public String editarAutor(Model model, @PathVariable long id,  @RequestParam Map<String, String> mappedAutor) {
        Autor autor = this.crearAutorDesdeMap(mappedAutor);

        Optional<Autor> opcional = this.autorRepository.findById(id);
        if(opcional.isPresent()){
            Autor autorAnterior = opcional.get();
            autorAnterior.actualizarAutor(autor);
            this.autorRepository.save(autorAnterior);
        }
        model.addAttribute("autores", autorRepository.findAll());

        return "autores";
    }

    @GetMapping("/{id}")
    public String consultaAutor(Model model, @PathVariable long id) {
        Optional<Autor> opcional = this.autorRepository.findById(id);
        opcional.ifPresent(autor -> model.addAttribute("autor", autor));

        return "infoAutor";
    }
    
    @GetMapping("/buscarPorNombreOApellidos")
    public String buscarAutorPorNombre(Model model, @RequestParam String nombreApellidos) {
        if (nombreApellidos == null || nombreApellidos.equals("")) {
            model.addAttribute("autores", autorRepository.findAll());
        } else {
            model.addAttribute("autores", autorRepository.findDistinctAutorByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(nombreApellidos, nombreApellidos));
        }

        return "autores";
    }
    
    @GetMapping("/buscarPorDNI")
    public String buscarAutorPorNif(Model model, @RequestParam String dni) {
        if (dni == null || dni.equals("")) {
            model.addAttribute("autores", autorRepository.findAll());
        } else {
            model.addAttribute("autores", autorRepository.findByNif(dni));
        }

        return "autores";
    }

    @GetMapping("/ordenar")
    public String buscarOrdenado(Model model, @RequestParam String sort) {
        model.addAttribute("autores", autorRepository.findAll(Sort.by(sort)));
        return "autores";
    }

    private Autor crearAutorDesdeMap(Map<String, String> mappedAutor) {
        Autor autor = new Autor();

        autor.setNombre(mappedAutor.get("nombre"));
        autor.setApellidos(mappedAutor.get("apellidos"));
        autor.setNif(mappedAutor.get("nif"));
        autor.setAnyoNacimiento(Integer.parseInt(mappedAutor.get("anyoNacimiento")));
        autor.setPaisNacimiento(mappedAutor.get("paisNacimiento"));
        autor.setEmail(mappedAutor.get("email"));
        autor.setTelefono(mappedAutor.get("telefono"));
        autor.setDireccionPostal(mappedAutor.get("direccionPostal"));

        return autor;
    }
}
