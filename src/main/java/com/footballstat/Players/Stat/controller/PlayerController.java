package com.footballstat.Players.Stat.controller;

import com.footballstat.Players.Stat.DTO.RecordDTO;
import com.footballstat.Players.Stat.services.RecordsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/players")
public class PlayerController {

    public final RecordsService recordsService;


    public PlayerController(RecordsService recordsService) {
        this.recordsService = recordsService;
    }

    @GetMapping("/mvp")
    public ResponseEntity <RecordDTO.PairStats> getMVP() {
        return ResponseEntity.ok(recordsService.findMVP());
    }
}
