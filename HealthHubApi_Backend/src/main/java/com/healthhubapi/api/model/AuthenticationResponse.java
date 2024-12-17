package com.healthhubapi.api.model;

public class AuthenticationResponse {

    private String jwt;

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}