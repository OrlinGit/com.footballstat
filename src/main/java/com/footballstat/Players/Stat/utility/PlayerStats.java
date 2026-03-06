package com.footballstat.Players.Stat.utility;

import com.footballstat.Players.Stat.DTO.RecordDTO;
import com.footballstat.Players.Stat.DTO.RecordDTO.MatchMinutes;

import java.util.ArrayList;
import java.util.List;

public class PlayerStats {

    private final Integer player1;
    private final Integer player2;
    private Integer totalMinutes = 0;
    private final List<MatchMinutes> matches = new ArrayList<>();

    public PlayerStats(Integer player1, Integer player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void addMatch(Integer matchId, Integer minutes){
        totalMinutes += minutes;
        matches.add(new MatchMinutes(matchId, minutes));
    }

    public Integer getTotalMinutes(){

        return totalMinutes;
    }

    public RecordDTO.PairStats build(){

        return new RecordDTO.PairStats(player1, player2, totalMinutes, matches);
    }
}
