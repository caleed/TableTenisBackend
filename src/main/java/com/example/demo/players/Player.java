package com.example.demo.players;

import com.example.demo.teams.Team;
import com.example.demo.utils.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Player extends BaseEntity {

    private String playerName;

    @ManyToOne
    private Team team;

    protected Player() {
        //JPA
    }

    public Player(String playerName, Team teams) {
        this.playerName = playerName;
        this.team = teams;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Team getTeams() {
        return team;
    }

    public void setTeams(Team teams) {
        this.team = teams;
    }
}
