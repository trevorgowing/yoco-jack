package com.trevorgowing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

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

      System.out.println("Calculated Winner: " + calculateWinner(handA, handB));
      System.out.println("Expected Winner: " + game.isPlayerAWins());
      System.out.println();
    }
  }

  private static boolean calculateWinner(List<Card> handA, List<Card> handB) {
    Integer valueA = handA.stream()
        .mapToInt(Card::getValue)
        .sum();

    Integer valueB = handB.stream()
        .mapToInt(Card::getValue)
        .sum();

    if (valueA > 21) {
      return false;
    } else if (valueB > 21) {
      return true;
    } else if (Objects.equals(valueA, valueB)) {
      return calculateHighestCardWinner(handA, handB);
    } else {
      return valueA > valueB;
    }
  }

  private static boolean calculateHighestCardWinner(List<Card> handA, List<Card> handB) {
    OptionalInt valueA = handA.stream()
        .mapToInt(Card::getValue)
        .max();

    OptionalInt valueB = handB.stream()
        .mapToInt(Card::getValue)
        .max();

    if (!valueA.isPresent()) {
      throw new IllegalArgumentException("Hand A has no cards");
    }
    if (!valueB.isPresent()) {
      throw new IllegalArgumentException("Hand B has no cards");
    }

    Integer maxA = valueA.getAsInt();
    Integer maxB = valueB.getAsInt();
    int comparison = maxA.compareTo(maxB);

    return comparison == 0 ? calculateSuiteWinner(handA, handB) : comparison > 0;
  }

  private static boolean calculateSuiteWinner(List<Card> handA, List<Card> handB) {
    return true;
  }
}
