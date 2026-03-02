package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class MatchesImportService {

    private final String pathToMatches = "src/main/resources/static/matches.csv";

    private final MatchesRepo matchesRepo;
    private final TeamRepo teamRepo;

    public MatchesImportService(MatchesRepo matchesRepo, TeamRepo teamRepo) {
        this.matchesRepo = matchesRepo;
        this.teamRepo = teamRepo;
    }

    void importMatches() throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(pathToMatches));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy");
            String firstLine = reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                String[] data = line.split(",");
                Integer id = Integer.parseInt(data[0]);
                Integer aTeamId = Integer.parseInt(data[1]);
                Integer bTeamId = Integer.parseInt(data[2]);
                LocalDate date = LocalDate.parse(data[3], formatter);
                String[] score = data[4].split("-");
                Integer aTeamResult = Integer.parseInt(score[0]);
                Integer bTeamResult = Integer.parseInt(score[1]);
                Team aTeam = teamRepo.getReferenceById(aTeamId);
                Team bTeam = teamRepo.getReferenceById(bTeamId);
                Matches matches = new Matches(id, aTeam, bTeam, date, aTeamResult, bTeamResult);
                matchesRepo.save(matches);
                line = reader.readLine();

             }
        } catch (Exception e) {
            throw new RuntimeException("Error reading file!");
        }
    }
}
