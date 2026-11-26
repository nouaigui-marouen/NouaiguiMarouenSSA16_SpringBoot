package tn.esprit.nouaiguimarouen4ssa16.Service.IServices;

import tn.esprit.nouaiguimarouen4ssa16.Domain.Vehicule;

import java.util.List;

public interface IVehiculeServices {
    Vehicule addVehicule(Vehicule vehicule);
    Vehicule updateVehicule(Long id, Vehicule vehicule);
    void deleteVehicule(Long id);
    Vehicule getById(Long id);
    List<Vehicule> findAll();
    Vehicule assignToAgence(Long idVehicule , Long idAgence );
    Vehicule unassignToAgence(Long idVehicule, Long idAgence);
    Vehicule assignToEquipements(Long idVehicule, Long idEquipement);
    Vehicule unassignToEquipements(Long idVehicule, Long idEquipement);

}
