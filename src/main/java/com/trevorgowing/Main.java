package com.trevorgowing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    URL url = new URL("https://s3-eu-west-1.amazonaws.com/yoco-testing/tests.json");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Game> games = objectMapper.readValue(url.openStream(), new TypeReference<List<Game>>(){});
    for (Game game : games) {
      System.out.println(game);
      List<Card> handA = new ArrayList<>();
      List<Card> handB = new ArrayList<>();

      game.getPlayerA().forEach(s -> handA.add(Card.fromString(s)));
      game.getPlayerB().forEach(s -> handB.add(Card.fromString(s)));

      System.out.println(handA);
      System.out.println(handA);

      System.out.println("Calculated Winner: " + new Calculator().calculateWinner(handA, handB));
      System.out.println("Expected Winner: " + game.isPlayerAWins());
      System.out.println();
    }
  }
}
