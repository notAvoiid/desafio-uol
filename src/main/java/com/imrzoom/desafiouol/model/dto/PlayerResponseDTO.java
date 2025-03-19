package com.imrzoom.desafiouol.model.dto;

import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.model.Player;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Player Response Data")
public record PlayerResponseDTO(
        @Schema(description = "Player ID", example = "1") Long id,
        @Schema(description = "Player name", example = "Igor") String name,
        @Schema(description = "Player email", example = "igoremailteste@gmail.com") String email,
        @Schema(description = "Player phone number", example = "11999999999") String phoneNumber,
        @Schema(description = "Unique codename", example = "Hulk") String codename,
        @Schema(description = "Player's group affiliation", example = "AVENGERS") GroupType groupType
) {

    public PlayerResponseDTO(Player player) {
        this(player.getId(), player.getName(), player.getEmail(), player.getPhoneNumber(), player.getCodename(), player.getGroupType());
    }
}
