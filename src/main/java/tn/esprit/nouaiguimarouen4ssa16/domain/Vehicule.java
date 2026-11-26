package tn.esprit.nouaiguimarouen4ssa16.Domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehicule;
    String immatriculation;
    String marque;
    String modele;

    @Enumerated(value = EnumType.STRING)
    CategorieVehicule categorie;

    BigDecimal tarifJournalier;

    @Enumerated(value = EnumType.STRING)
    StatutVehicule statut;
    @JsonBackReference
    @ManyToOne
    Agence agence;
    @ManyToMany
    Set<Equipement> equipements= new HashSet<>();
    @OneToMany(mappedBy = "vehicule")
    Set<Reservation> reservations;
    @OneToMany
    Set<Maintenance> maintenances;
}
