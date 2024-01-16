package com.imrzoom.desafiouol.service;

import com.imrzoom.desafiouol.infra.CodenameHandler;
import com.imrzoom.desafiouol.model.GroupType;
import com.imrzoom.desafiouol.model.Player;
import com.imrzoom.desafiouol.model.dto.PlayerDTO;
import com.imrzoom.desafiouol.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodenameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        Player newPlayer = new Player(dto);
        String codiname = getCodename(dto.groupType());
        newPlayer.setCodename(codiname);
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
