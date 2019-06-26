package com.uca.capas.domain.response;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class UsuarioTransfer {
    private String username;
    private List<String> roles;
    private String token;
    private Integer status;
    private String message;

    public UsuarioTransfer(String username, List<String> roles, String token, Integer status, String message) {
        this.roles = roles;
        this.token = token;
        this.username = username;
        this.status = status;
        this.message = message;
    }

    public UsuarioTransfer(String message, Integer status) {
        this.token = "";
        this.username = "";
        this.roles = Collections.emptyList();
        this.status = status;
        this.message = message;
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

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) { this.status = status; }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
