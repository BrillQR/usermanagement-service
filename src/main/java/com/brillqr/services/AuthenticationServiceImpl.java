package com.brillqr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.brillqr.dto.AuthenticationPayload;
import com.brillqr.dto.Response;
import com.brillqr.helper.ResponseHelper;
import com.brillqr.repositories.UserRepository;
import com.brillqr.security.MyUserDetailsService;
import com.brillqr.util.JwtUtil;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private MyUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Response authenticate(AuthenticationPayload authenticationPayload) {

		Response response = ResponseHelper.getResponseTemplate();
		
		com.brillqr.entities.UserDetails systemUserDetails = userRepository.findByemail(authenticationPayload.getEmail());
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationPayload.getEmail(),
					authenticationPayload.getPassword()));
			
		} catch (BadCredentialsException bad) {
			bad.printStackTrace();
			response.getError().put("error","Bad Credentials !!!!");
			return response;
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationPayload.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails,systemUserDetails);
		response.getData().put("jwt",jwt);
		
		return response;
	}

}
