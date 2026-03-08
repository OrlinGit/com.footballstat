package com.footballstat.Players.Stat.controller;

import com.footballstat.Players.Stat.DTO.MatchesDTO;
import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.services.MatchesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchesController {

    private final MatchesService matchesService;

    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @PostMapping
    public ResponseEntity<Matches> createNewMatch(@RequestBody @Valid MatchesDTO matchesDTO){
        try{
            Matches match = matchesService.createMatch(matchesDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(match);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Matches>> getAllMatches(){
        try{
            List<Matches> allMatches = matchesService.getAllMatches();
            return ResponseEntity.status(HttpStatus.OK).body(allMatches);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matches> getMatchById(@PathVariable Integer id){
        try{
            Matches match = matchesService.getMatchById(id);
            return ResponseEntity.status(HttpStatus.OK).body(match);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matches> updateMatch(@PathVariable Integer id, @RequestBody @Valid MatchesDTO matchesDTO){
        try{
            Matches match = matchesService.updateMatchById(id, matchesDTO);
            return ResponseEntity.status(HttpStatus.OK).body(match);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatchById(@PathVariable Integer id){
        try {
            matchesService.deleteMatchById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
