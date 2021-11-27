package esprit.spring.repository;

import esprit.spring.entities.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailProduitRepository extends JpaRepository <DetailProduit, Long > {
}
