package io.fouad.carrerbackend.user.dto;

import io.fouad.carrerbackend.user.Gender;

import java.util.List;

public record UserResponseDTO(
        Integer id,
        String name,
        String email,
        Gender gender,
        Integer age,
        List<String> roles,
        String profileImageId
) {
}
