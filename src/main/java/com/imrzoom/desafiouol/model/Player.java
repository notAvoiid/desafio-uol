package com.imrzoom.desafiouol.model;

import com.imrzoom.desafiouol.model.dto.PlayerDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "players") @Table(name = "players") @Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String phoneNumber;
    private String codename;
    private GroupType groupType;

    public Player(PlayerDTO dto){
        this.name = dto.name();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.groupType = dto.groupType();
    }
}
