package io.fouad.carrerbackend.user.dto;

import io.fouad.carrerbackend.user.Gender;

import java.util.List;

public record UserCreateDTO(
        String name,
        String email,
        String password,
        Gender gender,
        Integer age,
        List<String> roles,
        String username,
        String profileImageId
) {
}
