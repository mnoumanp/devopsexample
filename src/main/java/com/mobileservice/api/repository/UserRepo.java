package com.mobileservice.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mobileservice.api.entity.UserEntity;

@Repository
public interface UserRepo extends MongoRepository<UserEntity, String>{

	
	public UserEntity findOneByUserNameAndPassword(String userName,String password);
	
	public UserEntity findOneByUserName(String userName);
	
	public UserEntity findOneByEmployeeId(String employeeId);
	
	public Boolean existsByUserName(String userName);
	
	public Boolean existsByUserNameAndOtp(String userName,String otp);
	
	public UserEntity findOneByUserNameAndOtp(String userName,String otp);

}
