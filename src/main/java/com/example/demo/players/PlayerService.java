package com.example.demo.players;

import com.example.demo.teams.Team;
import com.example.demo.teams.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository1) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository1;
    }

    //public List<PlayerDto> getTeamPlayers(Long id){
    //    return playerRepository.findPlayersByTeamId(id).stream().map(PlayerDto::new).collect(Collectors.toList());
    //}

    @Transactional
    public PlayerDto addPlayer(NewPlayer newPlayer){
        Team team = teamRepository.findByIdRequired(newPlayer.getTeamId());
        Player player = new Player(
                newPlayer.getName(),
                team
        );
        return new PlayerDto(playerRepository.save(player));
    }
}
