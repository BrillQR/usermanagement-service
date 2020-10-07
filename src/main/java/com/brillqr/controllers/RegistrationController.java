package com.brillqr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brillqr.dto.CredentialPayload;
import com.brillqr.dto.Response;
import com.brillqr.dto.UserDetailsPayload;
import com.brillqr.services.RegistrationService;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	RegistrationService registrationService;
	
	@GetMapping("/hello")
	@ResponseBody
	public String helloUser() {
		return "Helllo there";
	}
	
	@PostMapping(value = "/user")
	@ResponseBody
	public ResponseEntity<Object> registerUser(@RequestBody UserDetailsPayload userDetailsPayload) {
		
		Response respone = registrationService.registerUser(userDetailsPayload);
		return new ResponseEntity(respone,HttpStatus.OK);
	}
	
	@PostMapping(value = "/credential")
	public ResponseEntity<Object> saveCredentials(@RequestBody CredentialPayload  credentialPayload){
		
		Response respone = registrationService.saveCredentials(credentialPayload);
		return new ResponseEntity(respone,HttpStatus.OK);
	}
}
