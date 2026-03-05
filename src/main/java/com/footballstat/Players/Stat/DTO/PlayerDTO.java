package com.footballstat.Players.Stat.DTO;

import jakarta.validation.constraints.*;

public class PlayerDTO {

    @NotNull
    @Min(1)
    @Max(99)
    private Integer teamNumber;

    @NotBlank
    @Size(min = 2, max = 25)
    private String position;

    @NotBlank
    @Size(min = 3, max = 255)
    private String fullName;

    @NotNull
    private Integer teamId;

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

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }
}
