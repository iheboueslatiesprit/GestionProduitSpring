package esprit.spring.service;

import esprit.spring.entities.DetailProduit;
import esprit.spring.repository.DetailProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailProduitServiceImpl implements DetailProduitService {
    @Autowired
    DetailProduitRepository detailProduitRep;

    @Override
    public DetailProduit addDetailProduit(DetailProduit d) {
        return detailProduitRep.save(d);
    }
}
