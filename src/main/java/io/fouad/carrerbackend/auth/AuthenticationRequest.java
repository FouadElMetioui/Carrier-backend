package io.fouad.carrerbackend.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
