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

    @PostMapping
    public Player getOrCreatePlayer(@RequestBody String token) {
        return playerService.getOrCreatePlayer(token);
    }

    @PostMapping("/{playerId}/heroes")
    public void addHeroToPlayer(@PathVariable("playerId") long playerId, @RequestBody Hero hero) {
        playerService.addHeroToPlayer(playerId, hero);
    }

}
