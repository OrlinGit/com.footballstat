package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Records;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class RecordsImportServices {

    private final String pathToRecords = "src/main/resources/static/records.csv";

    private final RecordsRepo recordsRepo;
    private final PlayerRepo playerRepo;
    private final MatchesRepo matchesRepo;

    public RecordsImportServices(RecordsRepo recordsRepo, PlayerRepo playerRepo, MatchesRepo matchesRepo) {
        this.recordsRepo = recordsRepo;
        this.playerRepo = playerRepo;
        this.matchesRepo = matchesRepo;
    }

    void importRecords() throws FileNotFoundException {
        try{
            BufferedReader reader = new BufferedReader(new FileReader(pathToRecords));
            String firstLine = reader.readLine();
            String line = reader.readLine();

            while(line != null){

                String[] data = line.split(",");
                Integer id = Integer.parseInt(data[0]);
                Integer playerId = Integer.parseInt(data[1]);
                Integer matchId = Integer.parseInt(data[2]);
                Integer fromMinutes = Integer.parseInt(data[3]);
                Integer toMinutes = data[4].equals("NULL")? 90 : Integer.parseInt(data[4]);
                Player player = playerRepo.getReferenceById(playerId);
                Matches matches = matchesRepo.getReferenceById(matchId);
                Records records = new Records(id, player, matches, fromMinutes, toMinutes);
                recordsRepo.save(records);
                line = reader.readLine();

            }

        } catch (IOException e) {
            throw new RuntimeException("Error reading file!");
        }
    }
}
