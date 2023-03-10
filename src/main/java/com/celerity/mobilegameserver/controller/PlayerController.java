package com.celerity.mobilegameserver.controller;

import com.celerity.mobilegameserver.model.Player;
import com.celerity.mobilegameserver.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        super();
        this.playerService = playerService;
    }
    @PostMapping
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) {
        return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
    }
}
