package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlayerImportService {

    private final String pathToPlayers = "src/main/resources/static/players.csv";

    private final PlayerRepo playerRepo;
    private final TeamRepo teamRepo;

    public PlayerImportService(PlayerRepo playerRepo, TeamRepo teamRepo) {
        this.playerRepo = playerRepo;
        this.teamRepo = teamRepo;
    }

    void importPlayers() throws IOException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToPlayers));
            String firstLine = reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                String[] data = line.split(",");
                Integer playerId = Integer.parseInt(data[0]);
                Integer teamNumber = Integer.parseInt(data[1]);
                String position = data[2];
                String fullName = data[3];
                Team teamId = teamRepo.getReferenceById(Integer.parseInt(data[4]));
                Player player = new Player(playerId, teamNumber, position, fullName, teamId);
                playerRepo.save(player);
                line = reader.readLine();
            }
        } catch (RuntimeException e) {
                throw new RuntimeException("Error reading file!");
        }
    }
}
