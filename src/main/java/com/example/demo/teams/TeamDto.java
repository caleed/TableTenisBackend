package com.example.demo.teams;

public class TeamDto {
    private Long id;

    private String name;

    public TeamDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public TeamDto(Team team){
        this.id = team.getId();
        this.name = team.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
