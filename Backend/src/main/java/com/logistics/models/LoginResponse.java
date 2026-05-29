package com.logistics.models;

public record LoginResponse(
        boolean success,
        String role
) {
}