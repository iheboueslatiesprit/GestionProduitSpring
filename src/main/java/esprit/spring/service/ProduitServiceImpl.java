package esprit.spring.service;


import esprit.spring.entities.*;
import esprit.spring.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImpl implements ProduitService{
    @Autowired
    ProduitRepository produitRepo;

    @Autowired
    RayonRepository rayonRepo;
    @Autowired
    StockRepository stockRepo;
    @Autowired
    DetailProduitRepository detailProduitRepo;
    @Autowired
    FournisseurRepository fournisseurRepo;

    @Override
    public List<Produit> retrieveAllProduits() {
        return produitRepo.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {
        Rayon r = rayonRepo.getById(idRayon);
        Stock s = stockRepo.getById(idStock);
        Produit produit = p ;
        produit.setRayon(r);
        produit.setStock(s);
       // produit.setFournisseur AJOUT STATIQUE EN TEST
        DetailProduit dp = p.getDetailProduit();
        detailProduitRepo.save(dp);
        return produitRepo.save(produit);

    }

    @Override
    public  void assignProduitToStock(Long idProduit, Long idStock) {
        Produit p = new Produit();
        p = produitRepo.getById(idProduit);
        Stock s = new Stock();
        s = stockRepo.getById(idStock);
        p.setStock(s);
       produitRepo.saveAndFlush(p);
    }
    @Override
    public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
    Fournisseur f = fournisseurRepo.getById(fournisseurId);
    Produit p = produitRepo.getById(produitId);
    p.getFournisseur().add(f);
    produitRepo.saveAndFlush(p);
    }


    @Override
    public Produit retrieveProduit(Long id) {
        return produitRepo.getById(id);
    }
}
