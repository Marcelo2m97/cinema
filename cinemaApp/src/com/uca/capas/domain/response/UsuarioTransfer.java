package com.uca.capas.domain.response;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class UsuarioTransfer {
    private String username;
    private List<String> roles;
    private String token;
    private HttpStatus status;

    public UsuarioTransfer(String username, List<String> roles, String token, HttpStatus status) {
        this.roles = roles;
        this.token = token;
        this.username = username;
        this.status = status;
    }

    public UsuarioTransfer() {
        this.token = "";
        this.username = "";
        this.roles = Collections.emptyList();
        this.status = HttpStatus.NOT_FOUND;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public String getToken() {
        return this.token;
    }

    public String getUsername() {
        return this.username;
    }

    public HttpStatus getStatus() {
        return this.status;
    }
}