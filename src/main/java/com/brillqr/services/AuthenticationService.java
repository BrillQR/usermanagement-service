package com.brillqr.services;

import com.brillqr.dto.AuthenticationPayload;
import com.brillqr.dto.Response;

public interface AuthenticationService {

		Response authenticate(AuthenticationPayload authenticationPayload);
}
