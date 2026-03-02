package com.footballstat.Players.Stat.utility;

import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import com.footballstat.Players.Stat.services.MatchesImportService;
import com.footballstat.Players.Stat.services.PlayerImportService;
import com.footballstat.Players.Stat.services.RecordsImportServices;
import com.footballstat.Players.Stat.services.TeamImportService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DBInitializer {

    private final TeamImportService teamImportService;
    private final PlayerImportService playerImportService;
    private final MatchesImportService matchesImportService;
    private final RecordsImportServices recordsImportServices;

    private final TeamRepo teamRepo;
    private final PlayerRepo playerRepo;
    private final MatchesRepo matchesRepo;
    private final RecordsRepo recordsRepo;

    public DBInitializer(TeamImportService teamImportService,
                         PlayerImportService playerImportService,
                         MatchesImportService matchesImportService,
                         RecordsImportServices recordsImportServices,
                         TeamRepo teamRepo,
                         PlayerRepo playerRepo,
                         MatchesRepo matchesRepo,
                         RecordsRepo recordsRepo) {
        this.teamImportService = teamImportService;
        this.playerImportService = playerImportService;
        this.matchesImportService = matchesImportService;
        this.recordsImportServices = recordsImportServices;
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
        this.matchesRepo = matchesRepo;
        this.recordsRepo = recordsRepo;
    }

    @PostConstruct

    public void initializeDB() throws IOException {
        if ( teamRepo.count() == 0){
            teamImportService.importTeams();
        }
        if (playerRepo.count() == 0) {
            playerImportService.importPlayers();
        }
        if (matchesRepo.count() == 0) {
            matchesImportService.importMatches();
        }
        if(recordsRepo.count() == 0) {
            recordsImportServices.importRecords();
        }
    }
}
