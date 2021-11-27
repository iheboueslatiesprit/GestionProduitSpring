package esprit.spring.service;

import esprit.spring.entities.Facture;

import java.util.Date;
import java.util.List;

public interface FactureService {
    List<Facture> retrieveAllFactures();
    void cancelFacture(Long id);
    Facture retrieveFacture(Long id);
    float calculChiffreAffaires(Date d1, Date d2);
}
