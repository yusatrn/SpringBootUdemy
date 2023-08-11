package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password){
        boolean isValidUsername=username.equalsIgnoreCase("root");
        boolean isValidPassword=password.equalsIgnoreCase("root");
        return isValidUsername && isValidPassword;
    }
}
