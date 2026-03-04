package com.footballstat.Players.Stat.DTO;

import java.util.List;

public class RecordDTO {

    public record PairStats(Integer player1, Integer player2, Integer totalMinutes, List<MatchMinutes> matches){}

    public record MatchMinutes(Integer matchId, Integer minutesTogether){}
}
