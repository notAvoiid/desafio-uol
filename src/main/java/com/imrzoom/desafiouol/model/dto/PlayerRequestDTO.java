package com.imrzoom.desafiouol.model.dto;

import com.imrzoom.desafiouol.model.GroupType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Player Request Data")
public record PlayerRequestDTO(
        @NotBlank @Schema(description = "Player name", example = "Igor") String name,
        @Email @NotBlank @Schema(description = "Player email", example = "igoremailteste@gmail.com") String email,
        @Schema(description = "Player phone number", example = "11999999999") String phoneNumber,
        @NotNull @Schema(description = "Player's group affiliation", example = "AVENGERS") GroupType groupType
) {
}
