package esprit.spring.tests;

import esprit.spring.entities.Fournisseur;
import esprit.spring.entities.Produit;
import esprit.spring.service.FournisseurService;
import esprit.spring.service.ProduitService;
import esprit.spring.service.ProduitServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.apache.logging.log4j.Logger;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {

    @Autowired
    ProduitService pr;
    @Autowired
    FournisseurService fr;
    @Transactional
    @Test
    public void TestAssignStock(){
        boolean b = false ;
        pr.assignProduitToStock(1L,2L);
        Produit p = pr.retrieveProduit(1L);
        if (p.getStock().getIdStock() == 2L ){
            b= true;
        }
    assertTrue(b);
    }

    @Transactional
    @Test
    public void TestAssignFournisseur(){
        boolean b = false ;
        pr.assignFournisseurToProduit(2L,1L);
        Produit p = pr.retrieveProduit(1L);
        Fournisseur f = fr.retrieveFournisseur(2L);
        log.warn(f.getLibelle());
        if (p.getFournisseur().contains(f)  ){
            b= true;
        }
        assertTrue(b);
    }
}

