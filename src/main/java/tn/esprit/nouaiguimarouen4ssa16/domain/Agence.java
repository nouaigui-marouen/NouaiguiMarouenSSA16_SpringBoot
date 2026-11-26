package tn.esprit.nouaiguimarouen4ssa16.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;
    @JsonManagedReference
    @OneToMany(mappedBy = "agence", fetch = FetchType.EAGER)
    List<Vehicule> vehicules;
    @OneToMany
    Set<Employe> employes;

}