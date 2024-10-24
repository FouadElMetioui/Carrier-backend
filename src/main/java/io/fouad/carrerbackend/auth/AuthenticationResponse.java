package io.fouad.carrerbackend.auth;

import io.fouad.carrerbackend.user.model.User;

public record AuthenticationResponse(
        String token,
        User user
) {
}
