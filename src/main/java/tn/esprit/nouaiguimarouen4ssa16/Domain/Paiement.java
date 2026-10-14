package tn.esprit.nouaiguimarouen4ssa16.Domain;

import jakarta.persistence.*;
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
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idPaiement;
    String montant;
    LocalDate datePaiement;
    @Enumerated(value = EnumType.STRING)

    ModePaiement modePaiement;



}
