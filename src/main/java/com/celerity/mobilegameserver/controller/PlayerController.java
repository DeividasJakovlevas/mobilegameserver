package com.celerity.mobilegameserver.controller;

import com.celerity.mobilegameserver.model.Hero;
import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        super();
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable("id") long id) {
        return playerService.getPlayerById(id);
    }

    @PostMapping
    public Player getOrCreatePlayer(@RequestBody String token) {
        return playerService.getOrCreatePlayer(token);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") long id) {
        playerService.deletePlayer(id);
    }

    @PostMapping("/{playerId}/heroes")
    public void addHeroToPlayer(@PathVariable("playerId") long playerId, @RequestBody Hero hero) {
        playerService.addHeroToPlayer(playerId, hero);
    }

    @DeleteMapping("/{playerId}/heroes")
    public void removeHeroFromPlayer(@PathVariable("playerId") long playerId, @RequestBody Hero hero) {
        playerService.removeHeroFromPlayer(playerId, hero);
    }
}
