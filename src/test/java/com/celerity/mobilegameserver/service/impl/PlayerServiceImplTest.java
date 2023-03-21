package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PlayerServiceImplTest {

    private PlayerServiceImpl playerService;

    @Mock
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerService = new PlayerServiceImpl(playerRepository);
    }

    @Test
    void updatePlayer() {
        Player player = new Player("Test","test_token", new ArrayList<>(), new ArrayList<>());
        when(playerRepository.save(any())).thenReturn(player);

        Player updatedPlayer = playerService.updatePlayer(player);

        assertNotNull(updatedPlayer);
        assertEquals(player.getName(), updatedPlayer.getName());
        assertEquals(player.getItems(), updatedPlayer.getItems());
        assertEquals(player.getUnits(), updatedPlayer.getUnits());
    }
    @Test
    public void testGetOrCreatePlayerWithExistingToken() {
        String token = "1234";
        Player player = new Player(token);
        List<Player> players = new ArrayList<>();
        players.add(player);

        when(playerRepository.findAll()).thenReturn(players);

        Player result = playerService.getOrCreatePlayer(token);

        assertEquals(player, result);
        verify(playerRepository, never()).save(any());
    }

    @Test
    public void testGetOrCreatePlayerWithNewToken() {
        String token = "5678";
        when(playerRepository.findAll()).thenReturn(new ArrayList<>());

        Player result = playerService.getOrCreatePlayer(token);

        assertEquals(token, result.getToken());
        assertEquals(3, result.getUnits().size());
        verify(playerRepository, times(1)).save(any());
    }

    @Test
    void getPlayerById() {
        Player player = new Player("Test","test_token", new ArrayList<>(), new ArrayList<>());
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        Player foundPlayer = playerService.getPlayerById(1L);

        assertNotNull(foundPlayer);
        assertEquals(player.getName(), foundPlayer.getName());
        assertEquals(player.getItems(), foundPlayer.getItems());
        assertEquals(player.getUnits(), foundPlayer.getUnits());
    }

    @Test
    void getAllPlayers() {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Test","test_token", new ArrayList<>(), new ArrayList<>());
        Player player2 = new Player("Test2","test_token", new ArrayList<>(), new ArrayList<>());
        players.add(player1);
        players.add(player2);
        when(playerRepository.findAll()).thenReturn(players);

        List<Player> foundPlayers = playerService.getAllPlayers();

        assertNotNull(foundPlayers);
        assertEquals(2, foundPlayers.size());
        assertEquals(players, foundPlayers);
    }


}