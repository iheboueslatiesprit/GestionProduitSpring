package esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="Produit")
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProduit")
    private long idProduit;
    private String code;
    private String libelle;
    private float prixUnitaire;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Rayon rayon;

    @JsonBackReference
    @ManyToOne
    private Stock stock;

    @JsonBackReference
    @OneToOne
    private DetailProduit detailProduit;

    @JsonManagedReference
    @OneToMany(cascade =  CascadeType.PERSIST , mappedBy = "produit")
    private Set<detailFacture> detailFacture;

    @JsonManagedReference
    @ManyToMany(cascade =  CascadeType.ALL)
    private Set<Fournisseur> fournisseur;


}
