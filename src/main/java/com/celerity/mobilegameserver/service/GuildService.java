package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Guild;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface GuildService {

    List<Guild> getAllGuilds();
    Guild createGuild(String guildName, String ownerToken);
    void addPlayerToGuild(String ownerToken, String playerToken);
    void addSeasonPointsToGuild(String ownerToken, int points);
}
