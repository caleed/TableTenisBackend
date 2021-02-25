package com.example.demo.teams;

import com.example.demo.players.Player;
import com.example.demo.utils.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team extends BaseEntity {

    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private List<Player> players;

    protected Team() {
        //JPA
    }

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, List<Player> players) {
        this.name = name;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
