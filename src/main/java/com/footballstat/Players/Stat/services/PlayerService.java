package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.PlayerDTO;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService implements PlayerInterface {

    private final PlayerRepo playerRepo;
    private final TeamRepo teamRepo;
    private final TeamService teamService;

    public PlayerService(PlayerRepo playerRepo,
                         TeamRepo teamRepo,
                         TeamService teamService) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
        this.teamService = teamService;
    }

    @Override
    @Transactional
    public Player createPlayer(@Valid PlayerDTO playerDTO) {
        Player player = new Player();

        player.setTeamNumber(playerDTO.getTeamNumber());
        player.setPosition(playerDTO.getPosition());
        player.setFullName(playerDTO.getFullName());
        Team team = teamService.getTeamById(playerDTO.getTeamId());
        player.setTeam(team);
        return playerRepo.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepo.findAll();
    }

    public Player getPlayerById(Integer playerId) {
        return playerRepo.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found!"));
    }

    @Transactional
    public Player updatePlayer(Integer playerId, @Valid PlayerDTO playerDTO) {
        Player player = playerRepo.findById(playerId).orElseThrow(() -> new RuntimeException("Player not found!"));

        player.setFullName(playerDTO.getFullName());
        player.setPosition(playerDTO.getPosition());
        player.setTeamNumber(playerDTO.getTeamNumber());
        Team team = teamService.getTeamById(playerDTO.getTeamId());
        player.setTeam(team);
        return playerRepo.save(player);
    }

    @Transactional
    public void deletePlayer(Integer playerId) {
        playerRepo.deleteById(playerId);
    }
}
