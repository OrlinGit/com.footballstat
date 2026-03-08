package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.MatchesDTO;
import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Team;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.TeamRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatchesService {

    private final MatchesRepo matchesRepo;
    private final TeamRepo teamRepo;

    public MatchesService(MatchesRepo matchesRepo, TeamRepo teamRepo) {
        this.matchesRepo = matchesRepo;
        this.teamRepo = teamRepo;
    }

    @Transactional
    public Matches createMatch(@Valid MatchesDTO matchesDTO){
        Matches match = new Matches();
        Team aTeam = teamRepo.findById(matchesDTO.getTeamAId()).orElseThrow(() -> new RuntimeException("Team not found!"));
        match.setATeam(aTeam);
        Team bTeam = teamRepo.findById(matchesDTO.getTeamAId()).orElseThrow(() -> new RuntimeException("Team not found!"));
        match.setBTeam(bTeam);
        match.setDate(matchesDTO.getDate());
        match.setaTeamResult(matchesDTO.getaTeamResult());
        match.setbTeamResult(matchesDTO.getbTeamResult());
        return matchesRepo.save(match);
    }

    public List<Matches> getAllMatches(){
        return matchesRepo.findAll();
    }

    public Matches getMatchById(Integer matchId){
        return matchesRepo.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found!"));
    }

    @Transactional
    public Matches updateMatchById(Integer matchId, @Valid MatchesDTO matchesDTO){
        Matches match = matchesRepo.findById(matchId).orElseThrow(() -> new RuntimeException("Match not found!"));
        Team aTeam = teamRepo.findById(matchesDTO.getTeamAId()).orElseThrow(() -> new RuntimeException("Team not found!"));
        match.setATeam(aTeam);
        Team bTeam = teamRepo.findById(matchesDTO.getTeamAId()).orElseThrow(() -> new RuntimeException("Team not found!"));
        match.setBTeam(bTeam);
        match.setDate(matchesDTO.getDate());
        match.setaTeamResult(matchesDTO.getaTeamResult());
        match.setbTeamResult(matchesDTO.getbTeamResult());
        return matchesRepo.save(match);
    }

    public void deleteMatchById(Integer matchId){
        matchesRepo.deleteById(matchId);
    }
}
