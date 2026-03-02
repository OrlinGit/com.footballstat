package com.footballstat.Players.Stat.repository;

import com.footballstat.Players.Stat.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordsRepo extends JpaRepository<Records, Integer> {
}
