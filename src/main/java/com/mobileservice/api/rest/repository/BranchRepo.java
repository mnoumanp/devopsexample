package com.mobileservice.api.rest.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mobileservice.api.entity.BranchEntity;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource(collectionResourceRel = "branch", path = "branch")
public interface BranchRepo extends MongoRepository<BranchEntity, String> {

	public List<BranchEntity> findAll();

	public List<BranchEntity> findByName(String name);

	public List<BranchEntity> findByAddress(String address);

	public BranchEntity findOneById(String id);

}
