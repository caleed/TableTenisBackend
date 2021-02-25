package com.example.demo.players;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ApiOperation(
            value = "Add new Player with name and team ID as an Input"
    )
    public PlayerDto addPlayer(@RequestBody NewPlayer newPlayer) {
        return playerService.addPlayer(newPlayer);
    }

}
