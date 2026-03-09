package com.footballstat.Players.Stat.controller;

import com.footballstat.Players.Stat.DTO.RecordAPIDTO;
import com.footballstat.Players.Stat.model.Records;
import com.footballstat.Players.Stat.services.RecordsAPIService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/records")
public class RecordsAPIController {

    public final RecordsAPIService recordsAPIService;

    public RecordsAPIController(RecordsAPIService recordsAPIService) {
        this.recordsAPIService = recordsAPIService;
    }


    @PostMapping
    public ResponseEntity<Records> createRecord(@RequestBody @Valid RecordAPIDTO recordAPIDTO) {
        try {
            Records record = recordsAPIService.createRecord(recordAPIDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(record);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Records>> getAllRecords() {
        try {
            List<Records> allRecords = recordsAPIService.getAllRecords();
            return ResponseEntity.status(HttpStatus.OK).body(allRecords);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Records> getRecordById(@PathVariable Integer id) {
        try {
            Records record = recordsAPIService.getRecordById(id);
            return ResponseEntity.status(HttpStatus.OK).body(record);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Records> updateRecordById(@PathVariable Integer id, @RequestBody @Valid RecordAPIDTO recordAPIDTO) {
        try {
            Records updatedRecord = recordsAPIService.updateRecordById(id, recordAPIDTO);
            return ResponseEntity.status(HttpStatus.OK).body(updatedRecord);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecordById(@PathVariable Integer id) {
        try {
            recordsAPIService.deleteRecordById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
