package com.DrugManagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.DrugManagement.Exception.DrugNotFoundException;
import com.DrugManagement.Model.Drug;
import com.DrugManagement.Service.DrugService;

@RestController
@RequestMapping("/drugs")
public class DrugController {
    private final DrugService drugService;

    @Autowired
    public DrugController(DrugService drugService) {
        this.drugService = drugService;
    }

    @GetMapping("/getAllDrugs")
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("getDrugById/{drugId}")
    public Drug getDrugById(@PathVariable String drugId) {
        return drugService.getDrugById(drugId);
    }

    @PostMapping("/addDrug")
    public Drug addDrug(@RequestBody Drug drug) {
        return drugService.addDrug(drug);
    }

    @PutMapping("updateDrug/{drugId}")
    public Drug updateDrug(@PathVariable String drugId, @RequestBody Drug updatedDrug) {
        return drugService.updateDrug(drugId, updatedDrug);
    }

    @DeleteMapping("deleteDrug/{drugId}")
    public void deleteDrug(@PathVariable String drugId) {
        drugService.deleteDrug(drugId);
    }

    @ExceptionHandler(DrugNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleDrugNotFoundException(DrugNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
