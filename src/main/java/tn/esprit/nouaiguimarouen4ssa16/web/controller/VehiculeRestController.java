package tn.esprit.nouaiguimarouen4ssa16.Web.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.nouaiguimarouen4ssa16.Domain.Vehicule;
import tn.esprit.nouaiguimarouen4ssa16.Service.IServices.IVehiculeServices;

import javax.crypto.spec.IvParameterSpec;
import java.util.List;

@Tag(name = "Nouaigui_Marouen", description = "Gestion : Vehicules")
@RestController
@RequiredArgsConstructor
public class VehiculeRestController {

    private final IVehiculeServices iVehiculeServices;
    @Operation(summary = "ajouter un véhicule")
    @PostMapping("/vehicules")
    Vehicule createVehicule(@RequestBody Vehicule vehicule){
        return iVehiculeServices.addVehicule(vehicule);
    }
    @Operation(summary = " Lister : Véhicules ")
    @GetMapping("/vehicules")
    List<Vehicule> getAllVehicules(){
        return iVehiculeServices.findAll();
    }
    @GetMapping("/vehicules/{id}")
    Vehicule getVehicle(@PathVariable("id") Long id) {
        return iVehiculeServices.getById(id);
    }
    @PutMapping("/vehicules/{id}")
    Vehicule modifierVehicule(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        return  iVehiculeServices.updateVehicule(id, vehicule);
    }
    @GetMapping("getAll")
    List<Vehicule> afficherVehicules(){
        return iVehiculeServices.findAll();
    }
    @DeleteMapping("{id}")
    void supprimerVehicule(@PathVariable Long idVehicule){
        iVehiculeServices.deleteVehicule(idVehicule);
    }
    @PutMapping("/assign/{idVehicule}/{idAgence}")
    Vehicule assignToAgence(@PathVariable Long idVehicule, @PathVariable Long idAgence){
        return iVehiculeServices.assignToAgence(idVehicule,idAgence);
    }
    @PutMapping("/assign/{idVehicule}/{idEquipement}")
    Vehicule asssignToEquipements(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return iVehiculeServices.assignToEquipements(idVehicule, idEquipement);
    }
    @PutMapping("/unassign/{idVehicule}/{idEquipement}")
    Vehicule unasssignToEquipements(@PathVariable Long idVehicule, @PathVariable Long idEquipement) {
        return iVehiculeServices.unassignToEquipements(idVehicule, idEquipement);
    }
    @PutMapping("/unassignToAgence/{idVehicule}/{idAgence}")
    Vehicule unassignToAgence(@PathVariable Long idVehicule, @PathVariable Long idAgence) {
        return iVehiculeServices.unassignToAgence(idVehicule, idAgence);
    }
}