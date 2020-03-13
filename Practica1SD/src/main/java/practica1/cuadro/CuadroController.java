package practica1.cuadro;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import practica1.autor.Autor;
import practica1.cliente.Cliente;

@Controller
@RequestMapping("/cuadro")
public class CuadroController {
    @Autowired
    private CuadroRepository cuadroRepository;
    
    
    
    @RequestMapping("/addCuadro")
    public String addCuadro(Model model) {
        return "nuevoCuadro";
    }

    @RequestMapping("/editarCuadro/{id}")
    public String editarCuadro(Model model, @PathVariable long id) {
        Optional<Cuadro> opcional = this.cuadroRepository.findById(id);
        if(opcional.isPresent()){
            model.addAttribute("cuadro", opcional.get());
        }

        return "editarCuadro";
    }
    

    @PostMapping("/")
    public String addCuadro(@RequestBody Cuadro cuadro) {
        this.cuadroRepository.save(cuadro);

        return "galeria";
    }
    
    
    
    @GetMapping("/{id}")
    public String editarCuadro(Model model, @PathVariable long id, @RequestParam Map<String, String> mappedCuadro) {
        Cuadro cuadro = this.crearCuadroDesdeMap(mappedCuadro);

        Optional<Cuadro> opcional = this.cuadroRepository.findById(id);
        if(opcional.isPresent()){
            Cuadro cuadroAnterior = opcional.get();
            cuadroAnterior.actualizarCuadro(cuadro);
            this.cuadroRepository.save(cuadroAnterior);
        }

        return "galeria";
    }

    private Cuadro crearCuadroDesdeMap(Map<String, String> mappedCuadro) {
        Cuadro cuadro = new Cuadro();

        cuadro.setTitulo(mappedCuadro.get("titulo"));
        cuadro.setDescripcion(mappedCuadro.get("descripcion"));
        cuadro.setAltura(Double.parseDouble(mappedCuadro.get("altura")));
        cuadro.setAnchura(Double.parseDouble(mappedCuadro.get("anchura")));
        cuadro.setAnyoFinalizacion(Integer.parseInt(mappedCuadro.get("anyoFinalizacion")));
    	cuadro.setPrecio(Integer.parseInt(mappedCuadro.get("precio")));
    	/*cuadro.setFechaVenta(Date.class.cast(mappedCuadro.get("fechaVenta")));
    	Object comprador = (Object) mappedCuadro.get("comprador");
    	cuadro.setComprador((Cliente)comprador);
    	Object autor = (Object) mappedCuadro.get("autor");
    	cuadro.setAutor((Autor)autor);*/
    	

        return cuadro;
    }
}
