package com.example.internalbookingmanagement.dto;


public record JwtAuthResponse(String accessToken, String refreshToken, String tokenType) {
    public JwtAuthResponse(String accessToken, String refreshToken) {
        this(accessToken, refreshToken, null);
    }
}
