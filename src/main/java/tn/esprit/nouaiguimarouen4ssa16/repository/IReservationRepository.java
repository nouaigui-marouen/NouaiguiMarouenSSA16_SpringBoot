package tn.esprit.nouaiguimarouen4ssa16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.nouaiguimarouen4ssa16.domain.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
