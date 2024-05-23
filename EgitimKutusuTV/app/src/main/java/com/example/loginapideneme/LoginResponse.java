package com.example.loginapideneme;

public class LoginResponse {
    private final boolean success;
    private final String token;
    private final String message;

    public LoginResponse(boolean success, String token, String message) {
        this.success = success;
        this.token = token;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
