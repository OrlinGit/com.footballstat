package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Transactional
public class PlayerImportService {

    ClassPathResource pathToPlayers = new ClassPathResource("static/players.csv");

    private final PlayerRepo playerRepo;
    private final TeamRepo teamRepo;

    public PlayerImportService(PlayerRepo playerRepo, TeamRepo teamRepo) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
    }

    public void importPlayers() {
        if (playerRepo.count() > 0) {
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pathToPlayers.getInputStream()));
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Integer teamNumber = Integer.parseInt(data[1]);
                String position = data[2];
                String fullName = data[3];
                Team team = teamRepo.getReferenceById(Integer.parseInt(data[4]));
                Player player = new Player(teamNumber, position, fullName, team);
                playerRepo.save(player);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
