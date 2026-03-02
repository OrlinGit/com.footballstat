package com.footballstat.Players.Stat.repository;

import com.footballstat.Players.Stat.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<Player, Integer> {
}
