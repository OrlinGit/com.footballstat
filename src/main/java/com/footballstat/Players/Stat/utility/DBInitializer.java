package com.footballstat.Players.Stat.utility;

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

    public DBInitializer(TeamImportService teamImportService,
                         PlayerImportService playerImportService,
                         MatchesImportService matchesImportService,
                         RecordsImportServices recordsImportServices) {
        this.teamImportService = teamImportService;
        this.playerImportService = playerImportService;
        this.matchesImportService = matchesImportService;
        this.recordsImportServices = recordsImportServices;
    }

    @PostConstruct

    public void initializeDB() throws IOException {
        teamImportService.importTeams();
        playerImportService.importPlayers();
        matchesImportService.importMatches();
        recordsImportServices.importRecords();
    }
}
