package com.footballstat.Players.Stat.services;


import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.TeamRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private static TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }

    public Team creataTeam(Team team){
        return teamRepo.save(team);
    }

    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

    public static Team getTeamById(Integer teamId){
        return teamRepo.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }

}
