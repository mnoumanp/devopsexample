package com.mobileservice.api.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mobileservice.api.entity.ListValueEntity;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "listvalue", path = "listvalue")
public interface ListValueRepo extends MongoRepository<ListValueEntity, String>{

    public List<ListValueEntity> findByName(String name);
    
    public List<ListValueEntity> findByFieldNameAndName(String fieldName, String name);
	
	public List<ListValueEntity> findByValue(String value);
}
