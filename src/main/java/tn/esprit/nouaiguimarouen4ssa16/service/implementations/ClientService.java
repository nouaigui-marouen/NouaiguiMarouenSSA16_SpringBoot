package tn.esprit.nouaiguimarouen4ssa16.Service.Implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.nouaiguimarouen4ssa16.Domain.Client;
import tn.esprit.nouaiguimarouen4ssa16.repository.IClientRepository;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private IClientRepository iClientRepository;
    public List<Client> getClients(){
        return iClientRepository.findAll();
    }

    public Client saveClient(Client client){
        return iClientRepository.save(client);
    }

    public void deleteClient(Long id){
        iClientRepository.deleteById(id);
    }
}
