package com.trevorgowing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.OptionalInt;

public class Main {

  private static final Map<String, Integer> cardValues;
  private static final Map<String, Integer> suiteValues;

  public static void main(String[] args) throws IOException {
    URL url = new URL("https://s3-eu-west-1.amazonaws.com/yoco-testing/tests.json");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Game> games = objectMapper.readValue(url.openStream(), new TypeReference<List<Game>>(){});
    for (Game game : games) {
      System.out.println(game);
      System.out.println("Calculated Winner: " + calculateWinner(game.getPlayerA(), game.getPlayerA()));
      System.out.println("Expected Winner: " + game.isPlayerAWins());
      System.out.println();
    }
  }

  private static boolean calculateWinner(List<String> handA, List<String> handB) {
    Integer valueA = handA.stream()
        .map(cardValues::get)
        .mapToInt(Integer::intValue)
        .sum();

    Integer valueB = handB.stream()
        .map(cardValues::get)
        .mapToInt(Integer::intValue)
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

  private static boolean calculateHighestCardWinner(List<String> handA, List<String> handB) {
    OptionalInt valueA = handA.stream()
        .map(cardValues::get)
        .mapToInt(Integer::intValue)
        .max();

    OptionalInt valueB = handB.stream()
        .map(cardValues::get)
        .mapToInt(Integer::intValue)
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

  private static boolean calculateSuiteWinner(List<String> handA, List<String> handB) {
    return true;
  }

  static {
    cardValues = new HashMap<>();
    cardValues.put("1C", 1);
    cardValues.put("2C", 2);
    cardValues.put("3C", 3);
    cardValues.put("4C", 4);
    cardValues.put("5C", 5);
    cardValues.put("6C", 6);
    cardValues.put("7C", 7);
    cardValues.put("8C", 8);
    cardValues.put("9C", 9);
    cardValues.put("10C", 10);
    cardValues.put("JC", 10);
    cardValues.put("QC", 10);
    cardValues.put("KC", 10);
    cardValues.put("AC", 11);
    cardValues.put("1D", 1);
    cardValues.put("2D", 2);
    cardValues.put("3D", 3);
    cardValues.put("4D", 4);
    cardValues.put("5D", 5);
    cardValues.put("6D", 6);
    cardValues.put("7D", 7);
    cardValues.put("8D", 8);
    cardValues.put("9D", 9);
    cardValues.put("10D", 10);
    cardValues.put("JD", 10);
    cardValues.put("QD", 10);
    cardValues.put("KD", 10);
    cardValues.put("AD", 11);
    cardValues.put("1H", 1);
    cardValues.put("2H", 2);
    cardValues.put("3H", 3);
    cardValues.put("4H", 4);
    cardValues.put("5H", 5);
    cardValues.put("6H", 6);
    cardValues.put("7H", 7);
    cardValues.put("8H", 8);
    cardValues.put("9H", 9);
    cardValues.put("10H", 10);
    cardValues.put("JH", 10);
    cardValues.put("QH", 10);
    cardValues.put("KH", 10);
    cardValues.put("AH", 11);
    cardValues.put("1S", 1);
    cardValues.put("2S", 2);
    cardValues.put("3S", 3);
    cardValues.put("4S", 4);
    cardValues.put("5S", 5);
    cardValues.put("6S", 6);
    cardValues.put("7S", 7);
    cardValues.put("8S", 8);
    cardValues.put("9S", 9);
    cardValues.put("10S", 10);
    cardValues.put("JS", 10);
    cardValues.put("QS", 10);
    cardValues.put("KS", 10);
    cardValues.put("AS", 11);
  }

  static {
    suiteValues = new HashMap<>();
    suiteValues.put("C", 2);
    suiteValues.put("D", 1);
    suiteValues.put("H", 3);
    suiteValues.put("S", 4);
  }
}
