package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
