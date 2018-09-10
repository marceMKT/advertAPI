package com.marce.idealista.advertAPI.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.marce.idealista.advertAPI.model.AdvertEntity;

public interface AdvertRepository extends MongoRepository<AdvertEntity, Long> {
	
	  @Query("{ 'points' : {\"$lt\" : ?0} }")
	  List<AdvertEntity> findIrrelevant(int point);

	  @Query("{ 'points' : {\"$gt\" : ?0} }")
	  List<AdvertEntity> findSortRelevant(int point, Sort sort);
	  
}   
	
