package com.imrzoom.desafiouol.model.dto;

import com.imrzoom.desafiouol.model.GroupType;

public record PlayerDTO(String name, String email, String phoneNumber, GroupType groupType) {
}
