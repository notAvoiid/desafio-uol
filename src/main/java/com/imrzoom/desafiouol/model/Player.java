package com.imrzoom.desafiouol.model;

import com.imrzoom.desafiouol.model.dto.PlayerRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "players")
@Table(name = "players")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String phoneNumber;
    private String codename;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GroupType groupType;

    public Player(PlayerRequestDTO dto, String codename){
        this.name = dto.name();
        this.email = dto.email();
        this.phoneNumber = dto.phoneNumber();
        this.groupType = dto.groupType();
        this.codename = codename;
    }
}
