package com.footballstat.Players.Stat.utility;

import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataParser {

    private TeamRepo teamRepo;
    private PlayerRepo playerRepo;
    private MatchesRepo matchesRepo;
    private RecordsRepo recordsRepo;

    static String pathToMatches = "src/main/resources/static/matches.csv";
    static String pathToPlayers = "src/main/resources/static/players.csv";
    static String pathToRecords = "src/main/resources/static/records.csv";
    static String pathToTeams = "src/main/resources/static/teams.csv";

    static void parseMatches() throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        BufferedReader reader = new BufferedReader(new FileReader(pathToMatches));
        String line = reader.readLine();
        while(line!= null){
        String[] match = line.split(",");
        Integer id = Integer.parseInt(match[0]);
        Integer aTeamId = Integer.parseInt(match[1]);
        Integer bTeamId = Integer.parseInt(match[2]);
        LocalDate date = LocalDate.parse(match[3], formatter);
        Integer aTeamScore = Integer.valueOf(match[4].split("-")[0]);
        Integer bTeamScore = Integer.valueOf(match[4].split("-")[1]);

        }

    }

}
