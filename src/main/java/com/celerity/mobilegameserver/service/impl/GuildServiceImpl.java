package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.exception.ResourceAlreadyExistsException;
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
            throw new ResourceNotFoundException("Unit","token", ownerToken);
        }
        if(guild.isPresent()){
            throw new ResourceAlreadyExistsException("Guild","name", guildName);
        }
        return guild.orElseGet(() -> new Guild(guildName, owner.get()));
    }
    @Override
    public void addSeasonPointsToGuild(String ownerToken, int points) {
        Guild guild = guildRepository.findByOwnerToken(ownerToken)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "token", ownerToken));
        guild.setSeasonPoints(guild.getSeasonPoints() + points);
        guildRepository.save(guild);
    }
    @Override
    public void addPlayerToGuild(String ownerToken, String playerToken) {
        Player player = playerRepository.findPlayerByToken(playerToken)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "token", ownerToken));
        Guild guild = guildRepository.findByOwnerToken(ownerToken)
                .orElseThrow(() -> new ResourceNotFoundException("Player", "token", playerToken));
        guild.getPlayers().add(player);
        guildRepository.save(guild);
    }

}
