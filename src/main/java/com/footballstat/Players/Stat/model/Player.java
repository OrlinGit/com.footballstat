package com.footballstat.Players.Stat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "player")

public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerId;

    @Column (nullable = false)
    private Integer teamNumber;

    @Column (length = 25)
    private String position;

    @Column (nullable = false)
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;


    public Player() {
    }

    public Player(Integer teamNumber, String position, String fullName, Team team) {
        this.teamNumber = teamNumber;
        this.position = position;
        this.fullName = fullName;
        this.team = team;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(Integer teamNumber) {
        this.teamNumber = teamNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
