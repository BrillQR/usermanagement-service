package com.brillqr.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDetailsPayload {
	
	private long id;
	
	private String userCode;
	
	private String email;
	
	private long contact;
	
	private boolean isAuthenticated;
	
	private LocalDate dateOfJoining;
	
	private String subscription;
}
