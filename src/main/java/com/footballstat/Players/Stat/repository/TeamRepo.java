package com.footballstat.Players.Stat.repository;

import com.footballstat.Players.Stat.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepo extends JpaRepository<Team, Integer> {


}
