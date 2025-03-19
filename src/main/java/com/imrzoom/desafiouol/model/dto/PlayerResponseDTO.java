package com.imrzoom.desafiouol.model.dto;

import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.model.Player;

public record PlayerResponseDTO(
        Long id,
        String name,
        String email,
        String phoneNumber,
        String codename,
        GroupType groupType
) {

    public PlayerResponseDTO(Player player) {
        this(player.getId(), player.getName(), player.getEmail(), player.getPhoneNumber(), player.getCodename(), player.getGroupType());
    }

}
