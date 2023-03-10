package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.repository.PlayerRepository;
import com.celerity.mobilegameserver.service.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository repository;

    public PlayerServiceImpl(PlayerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Player savePlayer(Player player) {
        return repository.save(player);
    }
}
