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
@Table(name="Rayon")
public class Rayon implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRayon")
private long idRayon;
private String code;
private String libelle;

@JsonManagedReference
@OneToMany(fetch = FetchType.LAZY ,cascade =  CascadeType.PERSIST , mappedBy = "rayon")
private Set<Produit> produits;
}
