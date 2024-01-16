package com.imrzoom.desafiouol.service;

import com.imrzoom.desafiouol.infra.CodenameHandler;
import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.model.Player;
import com.imrzoom.desafiouol.model.dto.PlayerDTO;
import com.imrzoom.desafiouol.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository repository;
    private final CodenameHandler handler;

    public PlayerService(PlayerRepository repository, CodenameHandler handler) {
        this.repository = repository;
        this.handler = handler;
    }

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codename = getCodename(dto.groupType());
        newPlayer.setCodename(codename);
        return repository.save(newPlayer);
    }

    @Transactional(readOnly = true)
    public List<Player> findAll(){
        return this.repository.findAll();
    }

    private String getCodename(GroupType groupType){
        return handler.findCodename(groupType);
    }

}
