package com.brillqr.services;

import com.brillqr.dto.CredentialPayload;
import com.brillqr.dto.Response;
import com.brillqr.dto.UserDetailsPayload;

public interface RegistrationService {

	Response registerUser(UserDetailsPayload userDetailsPayload);
	
	Response saveCredentials(CredentialPayload credentialsPayload);
	
}
