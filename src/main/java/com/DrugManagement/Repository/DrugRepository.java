package com.DrugManagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.DrugManagement.Model.Drug;

public interface DrugRepository extends MongoRepository<Drug, String> {
	
}
