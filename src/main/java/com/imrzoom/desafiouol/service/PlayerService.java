package com.imrzoom.desafiouol.service;

import com.imrzoom.desafiouol.infra.CodenameHandler;
import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.model.Player;
import com.imrzoom.desafiouol.model.dto.PlayerRequestDTO;
import com.imrzoom.desafiouol.model.dto.PlayerResponseDTO;
import com.imrzoom.desafiouol.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository repository;
    private final CodenameHandler handler;

    @Transactional
    public PlayerResponseDTO createPlayer(PlayerRequestDTO dto) {
        if (dto == null || dto.groupType() == null) {
            log.error("Invalid PlayerRequestDTO: {}", dto);
            throw new IllegalArgumentException("PlayerRequestDTO or groupType cannot be null");
        }

        if (repository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Email already in use: " + dto.email());
        }

        log.info("Creating a new player with name: {} and groupType: {}", dto.name(), dto.groupType());
        String codename = getCodename(dto.groupType());
        Player newPlayer = new Player(dto, codename);

        Player savedPlayer = repository.save(newPlayer);
        log.info("Player saved with ID: {}", savedPlayer.getId());

        return new PlayerResponseDTO(savedPlayer);
    }

    @Transactional(readOnly = true)
    public List<PlayerResponseDTO> findAll() {
        log.info("Fetching all players from the database");
        var players = repository.findAll()
                .stream()
                .map(PlayerResponseDTO::new)
                .toList();
        log.info("Found {} players", players.size());
        return players;
    }


    private String getCodename(GroupType groupType){
        log.debug("Fetching codename for groupType: {}", groupType);
        return handler.findCodename(groupType);
    }

}
