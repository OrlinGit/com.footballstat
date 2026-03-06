package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.PlayerDTO;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.stereotype.Service;

@Service
public class PlayerService implements PlayerInterface{

    private final PlayerRepo playerRepo;
    private final MatchesRepo matchesRepo;
    private final RecordsRepo recordsRepo;
    private final TeamRepo teamRepo;

    public PlayerService(PlayerRepo playerRepo, MatchesRepo matchesRepo, RecordsRepo recordsRepo, TeamRepo teamRepo) {
        this.playerRepo = playerRepo;
        this.matchesRepo = matchesRepo;
        this.recordsRepo = recordsRepo;
        this.teamRepo = teamRepo;
    }
    @Override
    public Player createPlayer(PlayerDTO playerDTO) {
        return null;
    }


}
