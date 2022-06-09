package com.app.springdataexp.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> getCustomerById(@RequestBody Object object) throws InterruptedException {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken("!thisisyour#fake@token!");
        //Thread.sleep(5000);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}