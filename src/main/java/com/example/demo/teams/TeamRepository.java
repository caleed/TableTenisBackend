package com.example.demo.teams;

import com.example.demo.utils.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends BaseRepository<Team, Long> {
    Team findTeamById(Long id);
}

