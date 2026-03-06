package com.footballstat.Players.Stat.services;

import com.footballstat.Players.Stat.DTO.PlayerDTO;
import com.footballstat.Players.Stat.model.Player;

public interface PlayerInterface {

    Player createPlayer(PlayerDTO playerDTO);


}
