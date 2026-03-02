package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class TeamImportService {

    private final TeamRepo teamRepo;

    static final String pathToTeams = "src/main/resources/static/teams.csv";

    public TeamImportService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public void importTeams () throws IOException{
         try {
             BufferedReader reader = new BufferedReader(new FileReader(pathToTeams));
             String firstLine = reader.readLine();
             String line = reader.readLine();

             while (line != null) {
                 String[] data = line.split(",");
                 Integer id = Integer.parseInt(data[0]);
                 String name = data[1];
                 String managerName = data[2];
                 String groupName = data[3];
                 Team team = new Team(id, name, managerName, groupName);
                 teamRepo.save(team);
                 line = reader.readLine();
             }
         } catch (IOException e){
             throw new RuntimeException("Error reading file!");
         }
    }
}
