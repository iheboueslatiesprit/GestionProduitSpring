package esprit.spring.repository;

import esprit.spring.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository <Produit, Long  > {

   /* @Modifying
    @Query("UPDATE Produit p SET p.stock = :idStock WHERE p.idProduit = :idProduit ")
     void assignProduitToStock(@Param("idProduit") Long idProduit,@Param("idStock") Long idStock); */

}
