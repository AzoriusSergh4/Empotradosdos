package practica1.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import practica1.GaleriaController;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController extends GaleriaController{
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @RequestMapping("/mostrarClientes")
    public String mostrarCuadros(Model model) {
    	cargaGaleria(model);    	
        return "clientes";
    }

    @RequestMapping("/addCliente")
    public String addClient(Model model) {
        return "nuevoCliente";
    }

    @RequestMapping("/editarCliente/{id}")
    public String editarCliente(Model model, @PathVariable long id) {
        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        if(opcional.isPresent()){
            model.addAttribute("cliente", opcional.get());
        }

        return "editarCliente";
    }

    @PostMapping("/")
    public String addCliente(Model model, @RequestParam Map<String, String> mappedCliente) {
        Cliente cliente = this.crearClienteDesdeMap(mappedCliente);

        this.clienteRepository.save(cliente);
        cargaGaleria(model);
        return "clientes";
    }

    @PostMapping("/{id}")
    public String editarCliente(Model model, @PathVariable long id, @RequestParam Map<String, String> mappedCliente) {
        Cliente cliente = this.crearClienteDesdeMap(mappedCliente);

        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        if(opcional.isPresent()){
            Cliente clienteAnterior = opcional.get();
            clienteAnterior.actualizarCliente(cliente);
            this.clienteRepository.save(clienteAnterior);
        }
        cargaGaleria(model);
        return "clientes";
    }

    @GetMapping("/{id}")
    public String consultaCliente(Model model, @PathVariable long id) {
        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        if(opcional.isPresent()){
            model.addAttribute("cliente", opcional.get());
        }
        return "infoCliente";
    }
    
    @GetMapping("/buscarPorNombreOApellidos")
    public String buscarClientePorNombre(Model model, @RequestParam String nombreApellidos) {
        if (nombreApellidos == null || nombreApellidos.equals("")) {
            cargaGaleria(model);
        } else {
            cargaGaleria(model);
            model.addAttribute("clientes", clienteRepository.findDistinctClienteByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(nombreApellidos, nombreApellidos));
        }

        return "clientes";
    }
    
    @GetMapping("/buscarPorDNI")
    public String buscarClienteporNif(Model model, @RequestParam String dni) {
        if (dni == null || dni.equals("")) {
            cargaGaleria(model);
        } else {
            cargaGaleria(model);
            model.addAttribute("clientes", clienteRepository.findByNif(dni));
        }

        return "clientes";
    }
    
    private Cliente crearClienteDesdeMap(Map<String, String> mappedCliente) {
        Cliente cliente = new Cliente();

        cliente.setNombre(mappedCliente.get("nombre"));
        cliente.setApellidos(mappedCliente.get("apellidos"));
        cliente.setNif(mappedCliente.get("nif"));;
        cliente.setEmail(mappedCliente.get("email"));
        cliente.setTelefono(mappedCliente.get("telefono"));
        cliente.setDireccionPostal(mappedCliente.get("direccionPostal"));

        return cliente;
    }
}
