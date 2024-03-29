package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.model.Player;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface PlayerService {
    Player getOrCreatePlayer(String token);
    Player updatePlayer(Player player);
    Player getPlayerById(long id);
    Player getPlayerByToken(String token);
    List<Player> getAllPlayers();
    void addUnitToPlayer(long playerId, Unit unit);
}
