package esprit.spring.repository;

import esprit.spring.entities.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RayonRepository extends JpaRepository <Rayon, Long > {

}
