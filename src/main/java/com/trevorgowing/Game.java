package com.trevorgowing;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
class Game {

  private List<String> playerA;
  private List<String> playerB;
  private boolean playerAWins;
}
