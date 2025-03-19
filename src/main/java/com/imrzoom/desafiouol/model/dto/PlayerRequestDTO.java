package com.imrzoom.desafiouol.model.dto;

import com.imrzoom.desafiouol.model.GroupType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record PlayerRequestDTO(
        @NotBlank String name,
        @Email @NotBlank String email,
        String phoneNumber,
        GroupType groupType
) {
}
