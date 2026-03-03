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
    private Player player;

    @ManyToOne(optional = false)
    @JoinColumn(name = "match_id", nullable = false)
    private Matches matches;

    @Column
    private Integer startInGameInMinutes;

    @Column
    private Integer endInGameInMinutes;

    public Records() {
    }

    public Records(Player player, Matches matches, Integer startInGameInMinutes, Integer endInGameInMinutes) {
        this.player = player;
        this.matches = matches;
        this.startInGameInMinutes = startInGameInMinutes;
        this.endInGameInMinutes = endInGameInMinutes;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Matches getMatches() {
        return matches;
    }

    public void setMatches(Matches matches) {
        this.matches = matches;
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
