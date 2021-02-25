package com.example.demo.teams;

import com.example.demo.players.PlayerDto;
import com.example.demo.utils.ValueResponseDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping()
    @ApiOperation(
            value = "Returns all teams"
    )
    public List<TeamDto> allTeams() {
        return this.teamService.getAllTeams();
    }

    @GetMapping("/{id}/players")
    @ApiOperation(
            value = "Return all selected by team ID players"
    )
    public List<PlayerDto> teamPlayers(@PathVariable Long id) {
        return teamService.getTeamPlayers(id);
    }


    @PostMapping
    @ApiOperation(
            value = "Add new Team with team name as input"
    )
    public ValueResponseDto<Long> addTeam(@RequestParam String name) {
        return new ValueResponseDto<>(this.teamService.addTeam(name));
    }



}
