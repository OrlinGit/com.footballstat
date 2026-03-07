package com.footballstat.Players.Stat.DTO;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class MatchesDTO {

    @NotNull
    @Positive
    private Integer teamAId;

    @NotNull
    @Positive
    private Integer teamBId;

    @NotNull
    @PastOrPresent
    private LocalDate date;

    @NotBlank
    @Size(min = 1, max = 7)
    private String aTeamResult;

    @NotBlank
    @Size(min = 1, max = 7)
    private String bTeamResult;

    public Integer getTeamAId() {
        return teamAId;
    }

    public void setTeamAId(Integer teamAId) {
        this.teamAId = teamAId;
    }

    public Integer getTeamBId() {
        return teamBId;
    }

    public void setTeamBId(Integer teamBId) {
        this.teamBId = teamBId;
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
