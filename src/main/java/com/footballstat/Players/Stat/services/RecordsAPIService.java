package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.RecordAPIDTO;
import com.footballstat.Players.Stat.model.Matches;
import com.footballstat.Players.Stat.model.Player;
import com.footballstat.Players.Stat.model.Records;
import com.footballstat.Players.Stat.repository.MatchesRepo;
import com.footballstat.Players.Stat.repository.PlayerRepo;
import com.footballstat.Players.Stat.repository.RecordsRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordsAPIService {

    public final RecordsRepo recordsRepo;
    public final PlayerRepo playerRepo;
    public final MatchesRepo matchesRepo;

    public RecordsAPIService(RecordsRepo recordsRepo, PlayerRepo playerRepo, MatchesRepo matchesRepo) {
        this.recordsRepo = recordsRepo;
        this.playerRepo = playerRepo;
        this.matchesRepo = matchesRepo;
    }

    @Transactional
    public Records createRecord(@Valid RecordAPIDTO recordAPIDTO){
        Records record = new Records();
        Player player = playerRepo
                .findById(recordAPIDTO.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found!"));
        record.setPlayer(player);
        Matches matches = matchesRepo
                .findById(recordAPIDTO.getMatchId())
                .orElseThrow(()-> new RuntimeException("Match not found!"));
        record.setMatches(matches);
        record.setStartInGameInMinutes(recordAPIDTO.getStartInGameInMinutes());
        record.setEndInGameInMinutes(recordAPIDTO.getEndInGameInMinutes());
        return recordsRepo.save(record);
    }

    public List<Records> getAllRecords(){
        return recordsRepo.findAll();
    }

    public Records getRecordById(Integer recordId){
        return recordsRepo.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found!"));
    }

    @Transactional
    public Records updateRecordById(Integer recordId, @Valid RecordAPIDTO recordAPIDTO){
        Records record = recordsRepo.findById(recordId).orElseThrow(() -> new RuntimeException("Record not found!"));
        Player player = playerRepo
                .findById(recordAPIDTO.getPlayerId())
                .orElseThrow(() -> new RuntimeException("Player not found!"));
        record.setPlayer(player);
        Matches matches = matchesRepo
                .findById(recordAPIDTO.getMatchId())
                .orElseThrow(() -> new RuntimeException("Match not found!"));
        record.setMatches(matches);
        record.setStartInGameInMinutes(recordAPIDTO.getStartInGameInMinutes());
        record.setEndInGameInMinutes(recordAPIDTO.getEndInGameInMinutes());
        return recordsRepo.save(record);
    }

    @Transactional
    public void deleteRecordById(Integer recordId){
        recordsRepo.deleteById(recordId);
    }
}
