package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.exception.ResourceNotFoundException;
import com.celerity.mobilegameserver.model.Guild;
import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.repository.GuildRepository;
import com.celerity.mobilegameserver.repository.PlayerRepository;
import com.celerity.mobilegameserver.service.GuildService;

import java.util.List;
import java.util.Optional;

public class GuildServiceImpl implements GuildService {
    private GuildRepository guildRepository;
    private PlayerRepository playerRepository;

    public GuildServiceImpl(PlayerRepository playerRepository,GuildRepository guildRepository) {
        this.playerRepository = playerRepository;
        this.guildRepository = guildRepository;
    }
    @Override
    public List<Guild> getAllGuilds() {
        return guildRepository.findAll();
    }

    @Override
    public Guild createGuild(String guildName, String ownerToken) {
        Optional<Player> owner = playerRepository.findPlayerByToken(ownerToken);
        Optional<Guild> guild = guildRepository.findByName(guildName);
        if(owner.isEmpty()){
            throw new ResourceNotFoundException("Hero","token", ownerToken);
        }
        return guild.orElseGet(() -> new Guild(guildName, owner.get()));
    }

    @Override
    public Guild addPlayerToGuild(String token, String playerToken) {
        return null;
    }

}
