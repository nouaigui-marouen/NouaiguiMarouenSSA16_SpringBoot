package tn.esprit.nouaiguimarouen4ssa16.Web.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.nouaiguimarouen4ssa16.Domain.Client;
import tn.esprit.nouaiguimarouen4ssa16.Service.Implementations.ClientService;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientRestController {
    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    //    @GetMapping("/welcome")
//    public String sayHello(){
//        return ("welcome the RestApi is alive and talking to the web");
        //    }

    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getClients();
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @DeleteMapping("/{id}")
    public String removeClient(@PathVariable Long id){
        clientService.deleteClient(id);
        return ("Client with ID : "+ id +" has been deleted ");

    }
}
