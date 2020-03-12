package practica1.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @RequestMapping("/addClient")
    public String addClient(Model model) {
        return "newClient";
    }

    @RequestMapping("/editClient/{id}")
    public String editAuthor(Model model, @PathVariable long id) {
        Optional<Client> optional = this.clientRepository.findById(id);
        if(optional.isPresent()){
            model.addAttribute("client", optional.get());
        }

        return "editClient";
    }

    @PostMapping("/")
    public String addClient(Model model, @RequestParam Map<String, String> mappedClient) {
        Client client = this.createClientFromMap(mappedClient);

        this.clientRepository.save(client);

        return "galeria";
    }

    @GetMapping("/{id}")
    public String editClient(Model model, @PathVariable long id, @RequestParam Map<String, String> mappedClient) {
        Client client = this.createClientFromMap(mappedClient);

        Optional<Client> optional = this.clientRepository.findById(id);
        if(optional.isPresent()){
            Client previousClient = optional.get();
            previousClient.updateClient(client);
            this.clientRepository.save(previousClient);
        }

        return "galeria";
    }

    private Client createClientFromMap(Map<String, String> mappedClient) {
        Client client = new Client();

        client.setName(mappedClient.get("name"));
        client.setSurnames(mappedClient.get("surnames"));
        client.setNif(mappedClient.get("nif"));
        client.setEmail(mappedClient.get("email"));
        client.setPhone(mappedClient.get("phone"));
        client.setPostalAddress(mappedClient.get("postalAddress"));

        return client;
    }
}
