package com.imrzoom.desafiouol.controller;

import com.imrzoom.desafiouol.model.Player;
import com.imrzoom.desafiouol.model.dto.PlayerDTO;
import com.imrzoom.desafiouol.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
@Tag(name = "Player", description = "Endpoint for managing your Player")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Creates a player!", description = "Creates a player!",
            tags = {"Player"},
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201",
                            content = @Content(schema = @Schema(implementation = Player.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

            })
    public ResponseEntity<Player> create(@RequestBody @Valid PlayerDTO playerDTO) {
        Player newPlayer = this.service.createPlayer(playerDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @GetMapping
    @Operation(summary = "List all players!", description = "List all players!",
            tags = {"Player"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Player.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)

            })
    public ResponseEntity<List<Player>> findAll(){
        List<Player> newPlayers = this.service.findAll();

        return ResponseEntity.ok().body(newPlayers);
    }

}
