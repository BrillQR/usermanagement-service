package com.brillqr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.brillqr.dto.AuthenticationPayload;
import com.brillqr.dto.Response;
import com.brillqr.security.MyUserDetailsService;
import com.brillqr.services.AuthenticationService;
import com.brillqr.util.JwtUtil;

@RestController
public class AuthenticationController {

	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value = "/authenticate" , method = RequestMethod.POST)
	public ResponseEntity<Object>  authenticate(@RequestBody AuthenticationPayload authenticationPayload) {
		
		Response response = authenticationService.authenticate(authenticationPayload);
		return new ResponseEntity(response,HttpStatus.OK);
	}
}
