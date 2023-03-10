package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Hero;
import com.celerity.mobilegameserver.model.Player;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface PlayerService {
    Player createPlayer(Player player);
    Player getOrCreatePlayer(String token);
    Player updatePlayer(Player player);
    Player getPlayerById(long id);
    Player getPlayerByToken(String token);
    List<Player> getAllPlayers();
    void deletePlayer(long id);
    void addHeroToPlayer(long playerId, Hero hero);
    void removeHeroFromPlayer(long playerId, Hero hero);
}
