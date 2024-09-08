package com.nullpay.wallet.auth.dto;

public class SignupUserDto {

    private String username;
    private String password;
    private String email;

    public SignupUserDto() {
    }

    public SignupUserDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
