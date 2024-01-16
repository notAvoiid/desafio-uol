package com.imrzoom.desafiouol.controller;

import com.imrzoom.desafiouol.model.Player;
import com.imrzoom.desafiouol.model.dto.PlayerDTO;
import com.imrzoom.desafiouol.service.PlayerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Player> create(@RequestBody @Valid PlayerDTO playerDTO) {
        Player newPlayer = this.service.createPlayer(playerDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        List<Player> newPlayers = this.service.findAll();

        return ResponseEntity.ok().body(newPlayers);
    }

}
