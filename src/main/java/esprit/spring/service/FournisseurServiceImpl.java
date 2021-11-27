package esprit.spring.service;

import esprit.spring.entities.Fournisseur;
import esprit.spring.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FournisseurServiceImpl implements FournisseurService{
    @Autowired
    FournisseurRepository fr;

    @Override
    public Fournisseur retrieveFournisseur(Long id){
      return  fr.getById(id);
    }

}
