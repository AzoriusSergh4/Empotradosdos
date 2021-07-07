package practica1.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        model.addAttribute("clientes", clienteRepository.findAll());
        return "clientes";
    }

    @RequestMapping("/addCliente")
    public String addClient(Model model) {
        return "nuevoCliente";
    }

    @PostMapping("/")
    public String addCliente(Model model, @RequestParam Map<String, String> mappedCliente) {
        Cliente cliente = this.crearClienteDesdeMap(mappedCliente);
        this.clienteRepository.save(cliente);
        model.addAttribute("clientes", clienteRepository.findAll());

        return "clientes";
    }

    @RequestMapping("/editarCliente/{id}")
    public String editarCliente(Model model, @PathVariable long id) {
        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        opcional.ifPresent(cliente -> model.addAttribute("cliente", cliente));

        return "editarCliente";
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
        model.addAttribute("clientes", clienteRepository.findAll());

        return "clientes";
    }

    @GetMapping("/{id}")
    public String consultaCliente(Model model, @PathVariable long id) {
        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        opcional.ifPresent(cliente -> model.addAttribute("cliente", cliente));

        return "infoCliente";
    }
    
    @GetMapping("/buscarPorNombreOApellidos")
    public String buscarClientePorNombre(Model model, @RequestParam String nombreApellidos) {
        if (nombreApellidos == null || nombreApellidos.equals("")) {
            model.addAttribute("clientes", clienteRepository.findAll());
        } else {
            model.addAttribute("clientes", clienteRepository.findDistinctClienteByNombreContainsIgnoreCaseOrApellidosContainsIgnoreCase(nombreApellidos, nombreApellidos));
        }

        return "clientes";
    }
    
    @GetMapping("/buscarPorDNI")
    public String buscarClienteporNif(Model model, @RequestParam String dni) {
        if (dni == null || dni.equals("")) {
            model.addAttribute("clientes", clienteRepository.findAll());
        } else {
            model.addAttribute("clientes", clienteRepository.findByNif(dni));
        }

        return "clientes";
    }

    @GetMapping("/ordenar")
    public String buscarOrdenado(Model model, @RequestParam String sort) {
        model.addAttribute("clientes", clienteRepository.findAll(Sort.by(sort)));
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
