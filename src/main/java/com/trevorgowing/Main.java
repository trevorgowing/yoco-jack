package com.trevorgowing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  private static final Map<String, Integer> cardValues;

  public static void main(String[] args) throws IOException {
    URL url = new URL("https://s3-eu-west-1.amazonaws.com/yoco-testing/tests.json");
    ObjectMapper objectMapper = new ObjectMapper();
    List<Game> games = objectMapper.readValue(url.openStream(), new TypeReference<List<Game>>(){});
    System.out.println(games);
    System.out.println(cardValues);
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
}
