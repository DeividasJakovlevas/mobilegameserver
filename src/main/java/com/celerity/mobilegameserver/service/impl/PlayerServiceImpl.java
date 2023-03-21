package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.model.CharacterType;
import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.repository.PlayerRepository;
import com.celerity.mobilegameserver.service.PlayerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player getOrCreatePlayer(String token) {
        Optional<Player> optionalPlayer = playerRepository.findAll().
                stream().
                filter(player-> player.getToken().equals(token))
                .findFirst();

        Player player = null;
        if(optionalPlayer.isEmpty()){
            player = new Player(token);

            Unit meleeWarrior = new Unit(CharacterType.UNIT_MELEE_WARRIOR);
            meleeWarrior.setPlayer(player);

            Unit rangedHealer = new Unit(CharacterType.UNIT_RANGED_HEALER);
            rangedHealer.setPlayer(player);

            Unit rangedArcher = new Unit(CharacterType.UNIT_RANGED_ARCHER);
            rangedArcher.setPlayer(player);

            player.getUnits().add(meleeWarrior);
            player.getUnits().add(rangedHealer);
            player.getUnits().add(rangedArcher);

            playerRepository.save(player);
        }
        return optionalPlayer.orElse(player);
    }

    @Override
    public Player updatePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayerById(long id) {
        Optional<Player> player = playerRepository.findById(id);
        return player.orElse(null);
    }

    @Override
    public Player getPlayerByToken(String token) {
        Optional<Player> player = playerRepository.findAll()
                .stream()
                .filter(player1 -> player1.getToken().equals(token))
                .findFirst();
        return player.orElse(null);
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public void addUnitToPlayer(long playerId, Unit unit) {
        Player player = getPlayerById(playerId);
        if (player != null) {
            player.getUnits().add(unit);
            unit.setPlayer(player);
            playerRepository.save(player);
        }
    }
}
