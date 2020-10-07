package com.brillqr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brillqr.entities.UserDetails;

public interface UserRepository extends JpaRepository<UserDetails,String> {

	UserDetails findByuserCode(String userCode);
	
	UserDetails findByemail(String email);
}
