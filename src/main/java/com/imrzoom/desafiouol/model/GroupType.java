package com.imrzoom.desafiouol.model;

import lombok.Getter;

@Getter
public enum GroupType {

    JUSTICE_LEAGUE("Justice League"),
    AVENGERS("Avengers");

    private final String description;

    GroupType(String description) {
        this.description = description;
    }

}
