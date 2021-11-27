package esprit.spring.repository;

import esprit.spring.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {


    @Query("SELECT c FROM Client c WHERE c.dateNaissance BETWEEN :date1 and :date2")
    List<Client> retrieveClientsDate(@Param("date1") Date date1, @Param("date2") Date date2);

}
