package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Transactional
public class TeamImportService {

    private final TeamRepo teamRepo;

    ClassPathResource pathToTeams = new ClassPathResource("static/teams.csv");

    public TeamImportService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public void importTeams() {
        if (teamRepo.count() > 0) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pathToTeams.getInputStream()));
            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[1];
                String managerName = data[2];
                String groupName = data[3];
                Team team = new Team(name, managerName, groupName);
                teamRepo.save(team);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
