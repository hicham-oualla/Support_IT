package com.it.support.service;

import com.it.support.model.Equipement;
import com.it.support.repository.EquipementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EquipementService {
    private final EquipementRepository equipementRepository;

    // Créer un nouvel équipement
    public Equipement createEquipement(Equipement equipement) {
        validateEquipement(equipement);
        return equipementRepository.save(equipement);
    }

    // Lire un équipement par ID
    public Optional<Equipement> getEquipementById(Long id) {
        return equipementRepository.findById(id);
    }

    // Lire tous les équipements
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }

    // Mettre à jour un équipement
    public Equipement updateEquipement(Long id, Equipement equipementDetails) throws Exception {
        validateEquipement(equipementDetails);
        return equipementRepository.findById(id)
                .map(equipement -> {
                    equipement.setNome(equipementDetails.getNome());
                    equipement.setStatus(equipementDetails.getStatus());
                    equipement.setPannes(equipementDetails.getPannes());
                    return equipementRepository.save(equipement);
                })
                .orElseThrow(() -> new Exception("Equipement not found with id " + id));
    }

    // Supprimer un équipement
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    // Méthode de validation pour vérifier que les champs obligatoires ne sont pas nuls
    private void validateEquipement(Equipement equipement) {
        if (equipement.getNome() == null || equipement.getNome().isEmpty()) {
            throw new IllegalArgumentException("Nome is mandatory");
        }
        if (equipement.getStatus() == null) {
            throw new IllegalArgumentException("Status is mandatory");
        }
    }
}
