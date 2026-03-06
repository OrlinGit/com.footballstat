package com.footballstat.Players.Stat.repository;

import com.footballstat.Players.Stat.model.Records;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RecordsRepo extends JpaRepository<Records, Integer> {


}
