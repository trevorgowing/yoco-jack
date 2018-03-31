package com.trevorgowing;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Game implements Serializable {

  private List<String> playerA;
  private List<String> playerB;
  private boolean playerAWins;

  List<String> getPlayerA() {
    return playerA;
  }

  List<String> getPlayerB() {
    return playerB;
  }

  boolean isPlayerAWinner() {
    return playerAWins;
  }
}
