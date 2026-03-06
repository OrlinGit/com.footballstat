package com.footballstat.Players.Stat.DTO;

import java.util.List;

public class RecordDTO {
    public static class MatchMinutes{
        private Integer matchId;
        private Integer minutes;

        public MatchMinutes(Integer matchId, Integer minutes){
            this.matchId = matchId;
            this.minutes = minutes;
        }

        public Integer getMatchId(){
            return matchId;
        }

        public void setMatchId(Integer matchId) {
            this.matchId = matchId;
        }

        public Integer getMinutes() {
            return minutes;
        }

        public void setMinutes(Integer minutes) {
            this.minutes = minutes;
        }
    }

    public static class PairStats {
        private Integer player1;
        private Integer player2;
        private Integer totalMinutes;
        private List<MatchMinutes> matches;

        public PairStats(Integer player1, Integer player2, Integer totalMinutes, List<MatchMinutes> matches) {
            this.player1 = player1;
            this.player2 = player2;
            this.totalMinutes = totalMinutes;
            this.matches = matches;
        }

        public Integer getPlayer1() {
            return player1;
        }

        public void setPlayer1(Integer player1) {
            this.player1 = player1;
        }

        public Integer getPlayer2() {
            return player2;
        }

        public void setPlayer2(Integer player2) {
            this.player2 = player2;
        }

        public Integer getTotalMinutes() {
            return totalMinutes;
        }

        public void setTotalMinutes(Integer totalMinutes) {
            this.totalMinutes = totalMinutes;
        }

        public List<MatchMinutes> getMatches() {
            return matches;
        }

        public void setMatches(List<MatchMinutes> matches) {
            this.matches = matches;
        }
    }
}
