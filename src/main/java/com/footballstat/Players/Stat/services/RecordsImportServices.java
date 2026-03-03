package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Records;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;


@Service
@Transactional
public class RecordsImportServices {

    private final ClassPathResource pathToRecords = new ClassPathResource("static/records.csv");

    private final RecordsRepo recordsRepo;
    private final PlayerRepo playerRepo;
    private final MatchesRepo matchesRepo;

    public RecordsImportServices(RecordsRepo recordsRepo, PlayerRepo playerRepo, MatchesRepo matchesRepo) {
        this.recordsRepo = recordsRepo;
        this.playerRepo = playerRepo;
        this.matchesRepo = matchesRepo;
    }

    public void importRecords() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(pathToRecords.getInputStream()))) {
            String line = reader.readLine(); // Skip header

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");
                Integer playerId = Integer.parseInt(data[1]);
                Integer matchId = Integer.parseInt(data[2]);
                Integer fromMinutes = Integer.parseInt(data[3]);
                Integer toMinutes = data[4].contains("NULL") ? 90 : parseScoreValue(data[4]);
                Player player = playerRepo.findById(playerId)
                        .orElseThrow(() ->
                                new RuntimeException("Player not found " + playerId));
                Matches match = matchesRepo.findById(matchId)
                        .orElseThrow(() ->
                                new RuntimeException("Match not found " + matchId));
                recordsRepo.save(new Records(player, match, fromMinutes, toMinutes));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private int parseScoreValue(String value) {
        return Integer.parseInt(value.replaceAll("\\D", ""));
    }
}
