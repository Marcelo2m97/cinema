package com.uca.capas.controller;

import com.uca.capas.domain.request.AuthenticationRequest;
import com.uca.capas.domain.response.UsuarioTransfer;
import com.uca.capas.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<UsuarioTransfer> authenticate(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            String username = authenticationRequest.getUsername();
            String password = authenticationRequest.getPassword();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = this.authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);

            List<String> roles = new ArrayList<>();

            for (GrantedAuthority authority : userDetails.getAuthorities()) {
                roles.add(authority.toString());
            }

            return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer(userDetails.getUsername(), roles,
                    TokenUtil.createToken(userDetails), HttpStatus.OK), HttpStatus.OK);

        } catch (BadCredentialsException bce) {
            return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer(), HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

