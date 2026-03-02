package com.footballstat.Players.Stat.repository;

import com.footballstat.Players.Stat.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchesRepo extends JpaRepository<Matches, Integer> {

}
