package com.example.internalbookingmanagement.dto;


public record ApiResponse(boolean success, Object data, String message) {

    public ApiResponse(boolean success, String message) {
        this(success, null, message);
    }

    public ApiResponse(boolean success, Object data) {
        this(success, data, null);
    }
}

