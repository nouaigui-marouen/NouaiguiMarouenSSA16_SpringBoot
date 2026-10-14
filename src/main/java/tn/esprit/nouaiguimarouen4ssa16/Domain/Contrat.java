package tn.esprit.nouaiguimarouen4ssa16.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idContrat;
    LocalDate dateSignature;
    int MontantTotal;
    Boolean valide;
}
