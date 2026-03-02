package com.footballstat.Players.Stat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "records")
public class Records {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer recordId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player playerId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private Matches matchId;

    @Column
    private Integer startInGameInMinutes;

    @Column
    private Integer endInGameInMinutes;

    public Records() {
    }

    public Records(Player playerId, Matches matchId, Integer startInGameInMinutes, Integer endInGameInMinutes) {
        this.playerId = playerId;
        this.matchId = matchId;
        this.startInGameInMinutes = startInGameInMinutes;
        this.endInGameInMinutes = endInGameInMinutes;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Matches getMatchId() {
        return matchId;
    }

    public void setMatchId(Matches matchId) {
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
