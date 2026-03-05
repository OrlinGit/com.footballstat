package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.model.Records;

import java.util.Optional;

public interface RecordsInterface {
    Optional<Records> findPlayerBy_playerIdAndMatchId_MatchId(Integer playerId, Integer matchId);
}
