package com.footballstat.Players.Stat.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RecordAPIDTO {

    @NotNull
    @Positive
    private Integer playerId;

    @NotNull
    @Positive
    private Integer matchId;

    @NotNull
    @Min(0)
    @Max(120)
    private Integer startInGameInMinutes;

    @Min(0)
    @Max(120)
    private Integer endInGameInMinutes;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getStartInGameInMinutes() {
        return startInGameInMinutes;
    }

    public void setStartInGameInMinutes(Integer startInGameInMinutes) {
        this.startInGameInMinutes = startInGameInMinutes;
    }

    public Integer getEndInGameInMinutes() {
        return endInGameInMinutes;
    }

    public void setEndInGameInMinutes(Integer endInGameInMinutes) {
        this.endInGameInMinutes = endInGameInMinutes;
    }
}
