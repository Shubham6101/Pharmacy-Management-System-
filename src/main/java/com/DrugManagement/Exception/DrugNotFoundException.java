package com.DrugManagement.Exception;

public class DrugNotFoundException extends RuntimeException {
    public DrugNotFoundException(String message) {
        super(message);
    }
}

