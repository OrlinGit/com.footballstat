package com.footballstat.Players.Stat.controller;


import com.footballstat.Players.Stat.DTO.TeamDTO;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.services.TeamService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teams")
public class TeamController {

    public final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@RequestBody @Valid TeamDTO teamDTO) {
        try {
            Team team = teamService.createTeam(teamDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(team);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Team>> getAllTeams() {
        try {
            List<Team> allTeams = teamService.getAllTeams();
            return ResponseEntity.status(HttpStatus.OK).body(allTeams);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable Integer id) {
        try {
            Team team = teamService.getTeamById(id);
            return ResponseEntity.status(HttpStatus.OK).body(team);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable Integer id, @RequestBody @Valid TeamDTO teamDTO) {
        try {
            Team team = teamService.updateTeam(id, teamDTO);
            return ResponseEntity.status(HttpStatus.OK).body(team);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Integer id) {
        try {
            teamService.deleteTeamById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
