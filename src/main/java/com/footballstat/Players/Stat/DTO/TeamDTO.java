package com.footballstat.Players.Stat.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TeamDTO {

    @NotBlank
    @Size(min = 3, max = 255)
    private String teamName;

    @NotBlank
    @Size(min = 3, max = 255)
    private String managerFullName;

    @NotBlank
    @Size(min = 1, max = 2)
    private String groupName;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getManagerFullName() {
        return managerFullName;
    }

    public void setManagerFullName(String managerFullName) {
        this.managerFullName = managerFullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
