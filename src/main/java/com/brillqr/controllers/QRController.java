package com.brillqr.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/qr")
public class QRController {

    
    @GetMapping(value = "/hello")
    public String hello() {
    	return "Hello";
    }
    
}
