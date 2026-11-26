package tn.esprit.nouaiguimarouen4ssa16.service.implementations;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.nouaiguimarouen4ssa16.domain.Agence;
import tn.esprit.nouaiguimarouen4ssa16.domain.Equipement;
import tn.esprit.nouaiguimarouen4ssa16.domain.Vehicule;
import tn.esprit.nouaiguimarouen4ssa16.dto.VehiculeResponseDTO;
import tn.esprit.nouaiguimarouen4ssa16.mapper.VehiculeMapper;
import tn.esprit.nouaiguimarouen4ssa16.service.iservices.IVehiculeServices;
import tn.esprit.nouaiguimarouen4ssa16.repository.IAgenceRepository;
import tn.esprit.nouaiguimarouen4ssa16.repository.IEquipementRepository;
import tn.esprit.nouaiguimarouen4ssa16.repository.IVehiculeRepository;

import java.util.List;
@Service
@RequiredArgsConstructor
public class VehiculeServices implements IVehiculeServices {

    private final IVehiculeRepository iVehiculeRepository;
    private final IAgenceRepository iAgenceRepository;
    private final IEquipementRepository iEquipementRepository;
    private final VehiculeMapper vehiculeMapper;

    @Override
    public Vehicule addVehicule(Vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule updateVehicule(Long id, Vehicule vehicule) {
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        iVehiculeRepository.deleteById(id);
    }

    @Override
    public Vehicule getById(Long id) {
        return iVehiculeRepository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("vehicule not found"));
        //instead of exception.get();
    }

    @Override
    public List<Vehicule> findAll() {
        return iVehiculeRepository.findAll();
    }

    private Vehicule getVehicule(Long idVehicule) {
        return iVehiculeRepository.findById(idVehicule)
                .orElseThrow(()->new EntityNotFoundException("Vehicle not found"));
    }

    @Override
    public VehiculeResponseDTO assignToAgence(Long idVehicule, Long idAgence) {
        Vehicule vehicule= getVehicule(idVehicule);
        Agence agence = iAgenceRepository.findById(idAgence)
                .orElseThrow(()-> new EntityNotFoundException("Vehicule not found" ));
        vehicule.setAgence(agence);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule unassignToAgence(Long idVehicule, Long idAgence){
        Vehicule vehicule = getVehicule(idVehicule);
        Agence agence =iAgenceRepository.findById(idAgence)
                .orElseThrow(() -> new EntityNotFoundException("Agency Not Found"));
        vehicule.setAgence(agence);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule assignToEquipements(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = getVehicule(idVehicule);
        Equipement equipement = iEquipementRepository.findById(idEquipement)
                .orElseThrow(()-> new EntityNotFoundException("Equipment not found"));
        vehicule.getEquipements().add(equipement);
        return iVehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule unassignToEquipements(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = getVehicule(idVehicule);
        Equipement equipement = iEquipementRepository
                .findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Equipment Not Found"));
        vehicule.getEquipements().remove(equipement);
        return iVehiculeRepository.save(vehicule);
    }

}
