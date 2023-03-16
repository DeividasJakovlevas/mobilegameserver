package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findPlayerByToken(String token);
}
