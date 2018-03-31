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
    int gameCounter = 1;
    int correctGameCounter = 0;
    for (Game game : games) {
      System.out.println("Game " + gameCounter++ + ":" + game);
      List<Card> handA = new ArrayList<>();
      List<Card> handB = new ArrayList<>();

      game.getPlayerA().forEach(s -> handA.add(Card.fromString(s)));
      game.getPlayerB().forEach(s -> handB.add(Card.fromString(s)));

      System.out.println(handA);
      System.out.println(handB);

      boolean calculatedWinner = new Calculator().calculateWinner(handA, handB);
      System.out.println("Calculated Winner: " + calculatedWinner);
      boolean expectedWinner = game.isPlayerAWins();
      System.out.println("Expected Winner: " + expectedWinner);
      correctGameCounter = calculatedWinner == expectedWinner ? correctGameCounter + 1
          : correctGameCounter;
      System.out.println();
    }
    System.out.println("Correct games: " + correctGameCounter);
  }
}
