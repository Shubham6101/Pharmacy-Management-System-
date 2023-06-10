package com.DrugManagement.Service;

import java.util.List;

import com.DrugManagement.Model.Drug;

public interface DrugService {
    List<Drug> getAllDrugs();
    Drug getDrugById(String drugId);
    Drug addDrug(Drug drug);
    Drug updateDrug(String drugId, Drug updatedDrug);
    void deleteDrug(String drugId);
}

