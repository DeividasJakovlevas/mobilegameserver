package com.celerity.mobilegameserver.repository;

import com.celerity.mobilegameserver.model.Guild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuildRepository extends JpaRepository<Guild,Long> {
    Optional<Guild> findByName(String name);
    Optional<Guild> findByOwnerToken(String token);
}
