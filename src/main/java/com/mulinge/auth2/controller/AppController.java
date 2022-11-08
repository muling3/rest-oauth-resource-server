package com.mulinge.auth2.controller;

import com.mulinge.auth2.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    TokenService tokenService;

    @Autowired
    AuthenticationManager authManager;

    private static  final Logger LOGGER = LoggerFactory.getLogger(AppController.class);

    @GetMapping
    public List<String> getList(){
        return List.of("George", "Boole", "Roy", "Fielding");
    }

    @GetMapping("/user")
    public String getLoggedUser(Principal principal){
        return "User is: "+principal.getName();
    }

    @GetMapping("/token")
    public String getAccessToken(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        LOGGER.info("username: {}, password: {}", username, password);

        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password, List.of(new SimpleGrantedAuthority("USER"))));
//        +this.tokenService.generateToken(authentication)

        return "Access token: "+this.tokenService.generateToken(authentication);
    }


}
