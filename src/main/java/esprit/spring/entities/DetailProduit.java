package esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="DetailProduit")
public class DetailProduit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailProduit")
    private long idDetailProduit;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    private String dateDerniereModification;
    @Enumerated(EnumType.STRING)
    private CategorieProduit categorieProduit;

    @JsonManagedReference
    @OneToOne(mappedBy = "detailProduit")
    private Produit produit;
}
