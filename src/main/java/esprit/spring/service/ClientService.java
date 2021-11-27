package esprit.spring.service;

import esprit.spring.entities.Client;

import java.util.Date;
import java.util.List;
public interface ClientService {

    List<Client> retrieveAllClients();
    Client addClient(Client c);
    void deleteClient(Long id);
    Client updateClient(Client c);
    Client retrieveClient(Long id);
    List<Client> retrieveClientsDate(Date date1, Date date2) ;
}
