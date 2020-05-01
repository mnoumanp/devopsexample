package com.mobileservice.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobileservice.api.entity.EmployeeEntity;
import com.mobileservice.api.entity.UserEntity;
import com.mobileservice.api.exception.EmployeeNotFoundException;
import com.mobileservice.api.exception.UnauthorizedException;
import com.mobileservice.api.model.ForgotPasswordModel;
import com.mobileservice.api.repository.EmployeeRepo;
import com.mobileservice.api.repository.UserRepo;
import com.mobileservice.api.util.ApplicationConstants;

@Service
public class AuthenticationService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private MessagingService messagingService;

	public UserEntity validateCredentials(String username, String password) {
		UserEntity userEntity = userRepo.findOneByUserNameAndPassword(username, password);
		if (userEntity == null) {
			throw new UnauthorizedException(ApplicationConstants.INVALID_USER_ERR);
		}
		return userEntity;
	}

	public UserEntity getUserByEmployeeId(String employeeId) {
		UserEntity userEntity = userRepo.findOneByEmployeeId(employeeId);
		if (userEntity == null) {
			throw new EmployeeNotFoundException();
		}
		return userEntity;
	}

	public ForgotPasswordModel forgetPassword(ForgotPasswordModel forgotPasswordModel) throws Exception {

		UserEntity userEntity = userRepo.findOneByUserName(forgotPasswordModel.getUserName());
		if (userEntity == null) {
			throw new EmployeeNotFoundException();
		}
		EmployeeEntity employeeEntity = employeeRepo.findOneById(userEntity.getEmployeeId());
		String otp = StringUtil.OTP();
		userEntity.setOtp(otp);
		userRepo.save(userEntity);

		// send email
		messagingService.sendOtpEmail(employeeEntity.getEmailId(), otp);
		return forgotPasswordModel;

	}

	public ForgotPasswordModel validateOTP(ForgotPasswordModel forgotPasswordModel) {
		UserEntity userEntity = userRepo.findOneByUserNameAndOtp(forgotPasswordModel.getUserName(), forgotPasswordModel.getEnteredOtp());
		if (userEntity==null) {
			throw new UnauthorizedException(ApplicationConstants.INVALID_OTP_ERR);
		}

		forgotPasswordModel.setValidOtp(true);
		userEntity.setPassword(forgotPasswordModel.getNewPassword());
		userRepo.save(userEntity);

		return forgotPasswordModel;

	}

}
