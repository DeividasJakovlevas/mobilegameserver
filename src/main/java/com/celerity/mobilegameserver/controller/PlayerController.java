package com.celerity.mobilegameserver.controller;

import com.celerity.mobilegameserver.model.Unit;
import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.service.PlayerService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{playerId}/units")
    public void addUnitToPlayer(@PathVariable("playerId") long playerId, @RequestBody Unit unit) {
        playerService.addUnitToPlayer(playerId, unit);
    }

}
