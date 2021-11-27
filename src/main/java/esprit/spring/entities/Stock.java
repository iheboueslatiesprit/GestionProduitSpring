package esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Stock")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStock")
    private long idStock;
    private int qte;
    private int qteMin;
    private String libelleStock;

    @JsonManagedReference
    @OneToMany( cascade =  CascadeType.ALL , mappedBy = "stock")
    private Set<Produit> produits;

}
