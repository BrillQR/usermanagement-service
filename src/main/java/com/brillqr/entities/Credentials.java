package com.brillqr.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credentials")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Credentials{

    @Transient
    private static final String DEFAULT_PASSWORD = "00000";

    @Id
    @Column(name="email",nullable = false, unique = true)
    private String email;

    @Column(name="user_code",nullable = false)
    private String userCode;

    @Column(name="password",nullable = false)
    private String password = DEFAULT_PASSWORD;

}

