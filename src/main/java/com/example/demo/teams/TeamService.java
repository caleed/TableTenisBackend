package com.example.demo.teams;

import com.example.demo.players.PlayerDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional(readOnly = true)
    public List<TeamDto> getAllTeams() {
        return teamRepository.findAll().stream().map(TeamDto::new).collect(Collectors.toList());
    }

    @Transactional
    public Long addTeam(String name) {
        var team = new Team(
                name
        );

        teamRepository.save(team);
        return team.getId();
    }

    @Transactional(readOnly = true)
    public List<PlayerDto> getTeamPlayers(Long id) {
        var team = teamRepository.findTeamById(id);

        if(team == null) {
            throw new RuntimeException("Not Found!");
        }

        return team.getPlayers().stream().map(PlayerDto::new).collect(Collectors.toList());
    }

}
