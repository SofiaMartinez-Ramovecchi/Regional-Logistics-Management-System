package com.logistics.models;

public record LoginRequest(
        String email,
        String password
) {
}