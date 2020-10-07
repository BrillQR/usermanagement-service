package com.brillqr.services;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.brillqr.dto.CredentialPayload;
import com.brillqr.dto.Response;
import com.brillqr.dto.UserDetailsPayload;
import com.brillqr.entities.Credentials;
import com.brillqr.entities.UserDetails;
import com.brillqr.exceptions.EntityNotFound;
import com.brillqr.helper.ResponseHelper;
import com.brillqr.repositories.CredentialsRepository;
import com.brillqr.repositories.UserRepository;


@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	CredentialsRepository credentialsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Response registerUser(UserDetailsPayload userDetailsPayload) {
		
		Response response = ResponseHelper.getResponseTemplate();
		
		UserDetails user = userRepository.findByemail(userDetailsPayload.getEmail());
		
		if(user==null) {
			user = new UserDetails();
			user.setAuthenticated(false);
			user.setEmail(userDetailsPayload.getEmail());
			user.setContact(userDetailsPayload.getContact());
			user.setDateOfJoining(LocalDate.now());
			user.setSubscription("free");
			user.setUserCode("USR-"+UUID.randomUUID().toString());
			
			user = userRepository.save(user);
			
			Credentials credentials = new Credentials();
			credentials.setEmail(userDetailsPayload.getEmail());
			credentials.setUserCode(user.getUserCode());
			
			credentialsRepository.save(credentials);
			
			response.getData().put("Sucess : ",user);
			return response;
			
		}else {
			response.getError().put("Error :", "Duplicate Entity Found For Email ");
			return response;
		}
	}

	@Override
	public Response saveCredentials(CredentialPayload credentialsPayload) {
		
		Response response = ResponseHelper.getResponseTemplate();
		
		Credentials credentials = credentialsRepository.findByemail(credentialsPayload.getEmail());
		
		if(credentials==null) 
			throw new EntityNotFound("No credentials Found for  provided  email "+ credentialsPayload.getEmail());
		
		String encryptedPassword = passwordEncoder.encode(credentialsPayload.getPassword());
		
		credentials.setPassword(encryptedPassword);
		
		credentialsRepository.save(credentials);		
		response.getData().put("Success :","credenrials generated");
		return response;
	}

}
