package com.footballstat.Players.Stat.services;


import com.footballstat.Players.Stat.DTO.TeamDTO;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.TeamRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {

    private final TeamRepo teamRepo;

    public TeamService(TeamRepo teamRepo) {
        this.teamRepo = teamRepo;
    }


    public Team getTeamById(Integer teamId){
        return teamRepo.findById(teamId).orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Transactional
    public Team createTeam(@Valid TeamDTO teamDTO){
        Team newTeam = new Team();
        newTeam.setTeamName(teamDTO.getTeamName());
        newTeam.setManagerFullName(teamDTO.getManagerFullName());
        newTeam.setGroupName(teamDTO.getGroupName());
        return teamRepo.save(newTeam);
    }

    public List<Team> getAllTeams(){
        return teamRepo.findAll();
    }

    @Transactional
    public Team updateTeam(Integer id, @Valid TeamDTO teamDTO){
        Team team = teamRepo.findById(id).orElseThrow(() -> new RuntimeException("Team not found!"));
        team.setTeamName(teamDTO.getTeamName());
        team.setManagerFullName(teamDTO.getManagerFullName());
        team.setGroupName(teamDTO.getGroupName());
        return teamRepo.save(team);
    }

    @Transactional
    public void deleteTeamById(Integer id){
        teamRepo.deleteById(id);
    }
}
