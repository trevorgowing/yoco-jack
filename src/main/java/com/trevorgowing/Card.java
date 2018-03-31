package com.trevorgowing;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
class Card {

  private static final Map<String, Integer> cardValues;
  private static final Map<String, Integer> suiteValues;

  String suite;
  String card;
  int value;

  static Card fromString(String cardString) {
    if (cardString.length() < 2) {
      throw new IllegalArgumentException(
          "Expected card of format number following by suite letter with no separator. e.g. 10D");
    }
    String suite = cardString.substring(cardString.length() - 1, cardString.length());
    String card = cardString.substring(0, cardString.length() -1);
    int value = cardValues.get(cardString);
    return new Card(suite, card, value);
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
