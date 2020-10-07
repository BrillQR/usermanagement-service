package com.brillqr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brillqr.entities.Credentials;

@Repository
public interface CredentialsRepository extends JpaRepository<Credentials,String> {
	
    Credentials findByemail(String email);

}
