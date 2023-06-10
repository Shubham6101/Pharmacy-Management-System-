package com.DrugManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DrugManagement.Exception.DrugNotFoundException;
import com.DrugManagement.Model.Drug;
import com.DrugManagement.Repository.DrugRepository;

@Service
public class DrugServiceImpl implements DrugService {
    private final DrugRepository drugRepository;

    @Autowired
    public DrugServiceImpl(DrugRepository drugRepository) {
        this.drugRepository = drugRepository;
    }

    @Override
    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @Override
    public Drug getDrugById(String drugId) {
        return drugRepository.findById(drugId)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + drugId));
    }

    @Override
    public Drug addDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    @Override
    public Drug updateDrug(String drugId, Drug updatedDrug) {
        Drug drug = drugRepository.findById(drugId)
                .orElseThrow(() -> new DrugNotFoundException("Drug not found with ID: " + drugId));

        drug.setDrugName(updatedDrug.getDrugName());
        drug.setQuantity(updatedDrug.getQuantity());
        drug.setExpiryDate(updatedDrug.getExpiryDate());
        drug.setPrice(updatedDrug.getPrice());

        return drugRepository.save(drug);
    }

    @Override
    public void deleteDrug(String drugId) {
        drugRepository.deleteById(drugId);
    }
}
