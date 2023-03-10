package com.celerity.mobilegameserver.service.impl;

import com.celerity.mobilegameserver.model.Hero;
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
    void createPlayer() {
        // given
        Player player = new Player("Test","test_token", 1000, 10, new ArrayList<>());
        when(playerRepository.save(any())).thenReturn(player);

        // when
        Player createdPlayer = playerService.createPlayer(player);

        // then
        assertNotNull(createdPlayer);
        assertEquals(player.getName(), createdPlayer.getName());
        assertEquals(player.getGold(), createdPlayer.getGold());
        assertEquals(player.getGems(), createdPlayer.getGems());
        assertEquals(player.getHeroes(), createdPlayer.getHeroes());
    }

    @Test
    void updatePlayer() {
        // given
        Player player = new Player("Test","test_token", 1000, 10, new ArrayList<>());
        when(playerRepository.save(any())).thenReturn(player);

        // when
        Player updatedPlayer = playerService.updatePlayer(player);

        // then
        assertNotNull(updatedPlayer);
        assertEquals(player.getName(), updatedPlayer.getName());
        assertEquals(player.getGold(), updatedPlayer.getGold());
        assertEquals(player.getGems(), updatedPlayer.getGems());
        assertEquals(player.getHeroes(), updatedPlayer.getHeroes());
    }

    @Test
    void getPlayerById() {
        // given
        Player player = new Player("Test","test_token", 1000, 10, new ArrayList<>());
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        // when
        Player foundPlayer = playerService.getPlayerById(1L);

        // then
        assertNotNull(foundPlayer);
        assertEquals(player.getName(), foundPlayer.getName());
        assertEquals(player.getGold(), foundPlayer.getGold());
        assertEquals(player.getGems(), foundPlayer.getGems());
        assertEquals(player.getHeroes(), foundPlayer.getHeroes());
    }

    @Test
    void getAllPlayers() {
        // given
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Test","test_token", 1000, 10, new ArrayList<>());
        Player player2 = new Player("Test2","test_token", 500, 5, new ArrayList<>());
        players.add(player1);
        players.add(player2);
        when(playerRepository.findAll()).thenReturn(players);

        // when
        List<Player> foundPlayers = playerService.getAllPlayers();

        // then
        assertNotNull(foundPlayers);
        assertEquals(2, foundPlayers.size());
        assertEquals(players, foundPlayers);
    }

    @Test
    void deletePlayer() {
        // given
        long playerId = 1L;

        // when
        playerService.deletePlayer(playerId);

        // then
        // verify that the repository's deleteById method was called with the correct id
        verify(playerRepository).deleteById(playerId);
    }

}