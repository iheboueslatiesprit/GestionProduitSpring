package esprit.spring.service;

import esprit.spring.entities.Facture;
import esprit.spring.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactureServiceImpl implements FactureService{
    @Autowired
    FactureRepository factureRepo;

    @Override
    public List<Facture> retrieveAllFactures() {
        return factureRepo.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
    Facture facture = factureRepo.getById(id);
    facture.setActive(false);
    factureRepo.save(facture);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return factureRepo.getById(id);
    }

    @Override
    public float calculChiffreAffaires(Date d1, Date d2){

        return factureRepo.calculChiffreAffaires(d1,d2);
    };
}
