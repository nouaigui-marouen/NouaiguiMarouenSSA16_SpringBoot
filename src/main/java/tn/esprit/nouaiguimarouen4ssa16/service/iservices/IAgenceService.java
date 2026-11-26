package tn.esprit.nouaiguimarouen4ssa16.Service.IServices;

import tn.esprit.nouaiguimarouen4ssa16.Domain.Agence;

import java.util.List;

public interface IAgenceService{
    Agence addAgence(Agence Agence);
    Agence updateAgence(Long id, Agence Agence);
    void deleteAgence(Long id);
    Agence getById(Long id);
    List<Agence> findAll();

}
