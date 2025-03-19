package com.imrzoom.desafiouol.repository;

import com.imrzoom.desafiouol.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByEmail(String email);
}
