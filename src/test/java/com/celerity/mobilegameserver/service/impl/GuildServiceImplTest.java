package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.model.Guild;
import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.repository.GuildRepository;
import com.celerity.mobilegameserver.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuildServiceImplTest {

    @Mock
    private GuildRepository guildRepository;
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private GuildServiceImpl guildService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        guildService = new GuildServiceImpl(playerRepository,guildRepository);
    }

    @Test
    void getAllGuilds() {
        List<Guild> guilds = new ArrayList<>();
        guilds.add(new Guild());
        guilds.add(new Guild());
        when(guildRepository.findAll()).thenReturn(guilds);

        List<Guild> result = guildRepository.findAll();

        assertEquals(2, result.size());
        verify(guildRepository, times(1)).findAll();
    }
}