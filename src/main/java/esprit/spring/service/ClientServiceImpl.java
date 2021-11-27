package esprit.spring.service;

import esprit.spring.entities.Client;
import esprit.spring.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    ClientRepository clientRepo;


    @Override
    public List<Client> retrieveAllClients() {
        return clientRepo.findAll();
    }

    @Override
    public Client addClient(Client c) {
        return clientRepo.save(c);
    }

    @Override
    public void deleteClient(Long id) {
       clientRepo.deleteById(id);
    }

    @Override
    public Client updateClient(Client c) {
        Client client = clientRepo.getById(c.getIdClient()) ;
        client.setCategorieClient(c.getCategorieClient());
        client.setDateNaissance(c.getDateNaissance());
        client.setEmail(c.getEmail());
      //  client.setFacture(c.getFacture());
        client.setNom(c.getNom());
        client.setPassword(c.getPassword());
        client.setPrenom(c.getPassword());
        client.setProfession(c.getProfession());

       return clientRepo.save(client);
    }

    @Override
    public Client retrieveClient(Long id) {
        return clientRepo.getById(id);
    }

    @Override
    public List<Client> retrieveClientsDate(Date date1, Date date2) {
        return clientRepo.retrieveClientsDate(date1,date2);
    }


}
