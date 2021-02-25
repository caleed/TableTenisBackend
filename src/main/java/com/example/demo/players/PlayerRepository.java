package com.example.demo.players;

import com.example.demo.utils.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends BaseRepository<Player, Long> {
    List<Player> findPlayersByTeamId(Long id);
}
