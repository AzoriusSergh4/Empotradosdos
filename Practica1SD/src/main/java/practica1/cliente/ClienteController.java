package practica1.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

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

        return "galeria";
    }

    @GetMapping("/{id}")
    public String editarCliente(Model model, @PathVariable long id, @RequestParam Map<String, String> mappedCliente) {
        Cliente cliente = this.crearClienteDesdeMap(mappedCliente);

        Optional<Cliente> opcional = this.clienteRepository.findById(id);
        if(opcional.isPresent()){
            Cliente clienteAnterior = opcional.get();
            clienteAnterior.actualizarCliente(cliente);
            this.clienteRepository.save(clienteAnterior);
        }

        return "galeria";
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
