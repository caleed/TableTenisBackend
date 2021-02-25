package com.example.demo.players;

import com.example.demo.teams.Team;
import com.example.demo.teams.TeamDto;

import javax.persistence.ManyToMany;
import java.util.List;

public class PlayerDto {

    private Long id;

    private String playerName;

    private TeamDto team;

    public PlayerDto(Long id,String playerName, TeamDto team) {
        this.id = id;
        this.playerName = playerName;
        this.team = team;
    }

    public PlayerDto(Player player) {
        this.id = player.getId();
        this.playerName = player.getPlayerName();
        this.team = new TeamDto(player.getTeams());
    }

    public String getPlayerName() {
        return playerName;
    }

    public TeamDto getTeams() {
        return team;
    }

    public Long getId() {
        return id;
    }
}
