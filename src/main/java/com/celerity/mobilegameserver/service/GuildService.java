package com.celerity.mobilegameserver.service;

import com.celerity.mobilegameserver.model.Guild;
import com.celerity.mobilegameserver.model.Hero;
import jakarta.transaction.Transactional;

import java.util.List;

@Transactional
public interface GuildService {

    List<Guild> getAllGuilds();
    Guild createGuild(String guildName, String ownerToken);
    Guild addPlayerToGuild(String token, String playerToken);
}
