package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.PlayerDTO;
import com.footballstat.Players.Stat.model.Player;

import java.util.List;

public interface PlayerInterface {

    Player createPlayer(PlayerDTO playerDTO);

    List<Player> getAllPlayers();

    Player getPlayerById(Integer playerId);
}
