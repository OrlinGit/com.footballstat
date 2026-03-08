package com.footballstat.Players.Stat.controller;

import com.footballstat.Players.Stat.DTO.PlayerDTO;
import com.footballstat.Players.Stat.DTO.RecordDTO;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.services.PlayerService;
import com.footballstat.Players.Stat.services.RecordsService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    public final RecordsService recordsService;
    public final PlayerService playerService;


    public PlayerController(RecordsService recordsService, PlayerService playerService) {
        this.recordsService = recordsService;
        this.playerService = playerService;
    }

    @GetMapping("/mvp")
    public ResponseEntity<RecordDTO.PairStats> getMVP() {
        return ResponseEntity.ok(recordsService.findMVP());
    }


    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO playerDTO) {
        try {
            Player player = playerService.createPlayer(playerDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(player);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        try {
            List<Player> allPlayers = playerService.getAllPlayers();
            return ResponseEntity.status(HttpStatus.OK).body(allPlayers);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable Integer id) {
        try {
            Player player = playerService.getPlayerById(id);
            return ResponseEntity.status(HttpStatus.OK).body(player);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Integer id, @RequestBody @Valid PlayerDTO playerDTO) {
        try {
            Player updatedPlayer = playerService.updatePlayer(id, playerDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedPlayer);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        try {
            playerService.deletePlayer(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}