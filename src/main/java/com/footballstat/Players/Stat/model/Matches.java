package com.footballstat.Players.Stat.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "matches")

public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matchId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "a_team_id", nullable = false)
    private Team aTeam;

    @ManyToOne(optional = false)
    @JoinColumn(name = "b_team_id", nullable = false)
    private Team bTeam;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer aTeamResult;

    @Column(nullable = false)
    private Integer bTeamResult;

    public Matches() {
    }

    public Matches(Team aTeam, Team bTeam, LocalDate date, Integer ATeamResult, Integer BTeamResult) {
        this.aTeam = aTeam;
        this.bTeam = bTeam;
        this.date = date;
        this.aTeamResult = ATeamResult;
        this.bTeamResult = BTeamResult;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Team getATeam() {
        return aTeam;
    }

    public void setATeam(Team aTeam) {
        this.aTeam = aTeam;
    }

    public Team getBTeam() {
        return bTeam;
    }

    public void setBTeam(Team bTeam) {
        this.bTeam = bTeam;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getaTeamResult() {
        return aTeamResult;
    }

    public void setaTeamResult(Integer aTeamResult) {
        this.aTeamResult = aTeamResult;
    }

    public Integer getbTeamResult() {
        return bTeamResult;
    }

    public void setbTeamResult(Integer bTeamResult) {
        this.bTeamResult = bTeamResult;
    }
}
