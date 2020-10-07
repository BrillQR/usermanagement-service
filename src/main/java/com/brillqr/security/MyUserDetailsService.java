package com.brillqr.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brillqr.entities.Credentials;
import com.brillqr.repositories.CredentialsRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	CredentialsRepository credentialsRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Credentials credentials = credentialsRepository.findByemail(email);
		
		return new User(credentials.getEmail(), credentials.getPassword(), new ArrayList<>());
	}

	
}
