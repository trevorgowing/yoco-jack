package com.trevorgowing;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
class Game {

  private List<String> playerA;
  private List<String> playerB;
  private boolean playerAWins;

  List<String> getPlayerA() {
    return playerA;
  }

  List<String> getPlayerB() {
    return playerB;
  }

  boolean isPlayerAWins() {
    return playerAWins;
  }
}
