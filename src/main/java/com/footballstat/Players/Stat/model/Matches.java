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
    private String aTeamResult;

    @Column(nullable = false)
    private String bTeamResult;

    public Matches() {
    }

    public Matches(Team aTeam, Team bTeam, LocalDate date, String ATeamResult, String BTeamResult) {
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

    public String getaTeamResult() {
        return aTeamResult;
    }

    public void setaTeamResult(String aTeamResult) {
        this.aTeamResult = aTeamResult;
    }

    public String getbTeamResult() {
        return bTeamResult;
    }

    public void setbTeamResult(String bTeamResult) {
        this.bTeamResult = bTeamResult;
    }
}
