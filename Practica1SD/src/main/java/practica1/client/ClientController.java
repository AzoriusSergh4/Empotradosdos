package practica1.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @PostMapping("/")
    public void addClient(@RequestBody Client client) {
        this.clientRepository.save(client);
    }

    @PutMapping("/{id}")
    public void editAuthor(@PathVariable long id, @RequestBody Client client) {
        Optional<Client> optional = this.clientRepository.findById(id);
        if(optional.isPresent()){
            Client previousClient = optional.get();
            previousClient.updateClient(client);
            this.clientRepository.save(previousClient);
        }
    }
}
