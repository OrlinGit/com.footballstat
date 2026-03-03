package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
public class MatchesImportService {

    ClassPathResource pathToMatches = new ClassPathResource("static/matches.csv");

    private final MatchesRepo matchesRepo;
    private final TeamRepo teamRepo;

    public MatchesImportService(MatchesRepo matchesRepo, TeamRepo teamRepo) {
        this.matchesRepo = matchesRepo;
        this.teamRepo = teamRepo;
    }

    public void importMatches() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(pathToMatches.getInputStream()));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

            String line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Integer aTeamId = Integer.parseInt(data[1]);
                Integer bTeamId = Integer.parseInt(data[2]);
                LocalDate date = LocalDate.parse(data[3], formatter);
                String[] score = data[4].split("-");
                String aTeamResult = score[0];
                String bTeamResult = score[1];
                Team aTeam = teamRepo.getReferenceById(aTeamId);
                Team bTeam = teamRepo.getReferenceById(bTeamId);
                Matches matches = new Matches(aTeam, bTeam, date, aTeamResult, bTeamResult);
                matchesRepo.save(matches);
             }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
