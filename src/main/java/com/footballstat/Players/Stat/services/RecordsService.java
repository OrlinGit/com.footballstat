package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.RecordDTO;
import com.footballstat.Players.Stat.model.Records;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import com.footballstat.Players.Stat.utility.PlayerStats;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

    @Service
    public class RecordsService {

        private final RecordsRepo recordsRepo;

        public RecordsService(RecordsRepo recordsRepo) {
            this.recordsRepo = recordsRepo;
        }

        public RecordDTO.PairStats findMVP() {
            List<Records> records = recordsRepo.findAll();

            Map<Integer, List<Records>> byMatch = records.stream()
                    .collect(Collectors.groupingBy(r -> r.getMatches().getMatchId()));

            Map<String, PlayerStats> pairMap = new HashMap<>();
            for (List<Records> matchRecords : byMatch.values()) {
                for (int i = 0; i < matchRecords.size(); i++) {
                    for (int j = i + 1; j < matchRecords.size(); j++) {
                        Records player1 = matchRecords.get(i);
                        Records player2 = matchRecords.get(j);

                        int overlap = calculateOverlap(
                                player1.getStartInGameInMinutes(),
                                player1.getEndInGameInMinutes(),
                                player2.getStartInGameInMinutes(),
                                player2.getEndInGameInMinutes()
                        );

                        if (overlap > 0) {

                            int p1 = player1.getPlayer().getPlayerId();
                            int p2 = player2.getPlayer().getPlayerId();

                            int min = Math.min(p1, p2);
                            int max = Math.max(p1, p2);

                            String key = min + "-" + max;
                            pairMap.computeIfAbsent(key, k -> new PlayerStats(min, max))
                                    .addMatch(player1.getMatches().getMatchId(), overlap);
                        }
                    }
                }
            }
            return pairMap.values()
                    .stream()
                    .max(Comparator.comparingInt(PlayerStats::getTotalMinutes))
                    .map(PlayerStats::build)
                    .orElseThrow();
        }
        private int calculateOverlap(int start1, int end1, int start2, int end2) {
            int start = Math.max(start1, start2);
            int end = Math.min(end1, end2);
            return Math.max(0, end - start);
        }
    }

