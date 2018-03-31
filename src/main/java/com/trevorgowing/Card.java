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
class Card implements Comparable<Card> {

  private static final Map<String, Integer> cardValues;
  private static final Map<String, Integer> gameValues;
  private static final Map<String, Integer> suiteValues;

  String suite;
  String card;
  int cardValue;
  int gameValue;

  static Card fromString(String cardString) {
    if (cardString.length() < 2) {
      throw new IllegalArgumentException(
          "Expected card of format number following by suite letter with no separator. e.g. 10D");
    }
    String suite = cardString.substring(cardString.length() - 1, cardString.length());
    String card = cardString.substring(0, cardString.length() -1);
    int cardValue = cardValues.get(card);
    int gameValue = gameValues.get(cardString);
    return new Card(suite, card, cardValue, gameValue);
  }

  @Override
  public int compareTo(Card card) {
    return Integer.compare(this.getGameValue(), card.getGameValue());
  }

  static {
    cardValues = new HashMap<>();
    cardValues.put("1", 1);
    cardValues.put("2", 2);
    cardValues.put("3", 3);
    cardValues.put("4", 4);
    cardValues.put("5", 5);
    cardValues.put("6", 6);
    cardValues.put("7", 7);
    cardValues.put("8", 8);
    cardValues.put("9", 9);
    cardValues.put("10", 10);
    cardValues.put("J", 11);
    cardValues.put("Q", 12);
    cardValues.put("K", 13);
    cardValues.put("A", 14);
  }

  static {
    gameValues = new HashMap<>();
    gameValues.put("1C", 1);
    gameValues.put("2C", 2);
    gameValues.put("3C", 3);
    gameValues.put("4C", 4);
    gameValues.put("5C", 5);
    gameValues.put("6C", 6);
    gameValues.put("7C", 7);
    gameValues.put("8C", 8);
    gameValues.put("9C", 9);
    gameValues.put("10C", 10);
    gameValues.put("JC", 10);
    gameValues.put("QC", 10);
    gameValues.put("KC", 10);
    gameValues.put("AC", 11);
    gameValues.put("1D", 1);
    gameValues.put("2D", 2);
    gameValues.put("3D", 3);
    gameValues.put("4D", 4);
    gameValues.put("5D", 5);
    gameValues.put("6D", 6);
    gameValues.put("7D", 7);
    gameValues.put("8D", 8);
    gameValues.put("9D", 9);
    gameValues.put("10D", 10);
    gameValues.put("JD", 10);
    gameValues.put("QD", 10);
    gameValues.put("KD", 10);
    gameValues.put("AD", 11);
    gameValues.put("1H", 1);
    gameValues.put("2H", 2);
    gameValues.put("3H", 3);
    gameValues.put("4H", 4);
    gameValues.put("5H", 5);
    gameValues.put("6H", 6);
    gameValues.put("7H", 7);
    gameValues.put("8H", 8);
    gameValues.put("9H", 9);
    gameValues.put("10H", 10);
    gameValues.put("JH", 10);
    gameValues.put("QH", 10);
    gameValues.put("KH", 10);
    gameValues.put("AH", 11);
    gameValues.put("1S", 1);
    gameValues.put("2S", 2);
    gameValues.put("3S", 3);
    gameValues.put("4S", 4);
    gameValues.put("5S", 5);
    gameValues.put("6S", 6);
    gameValues.put("7S", 7);
    gameValues.put("8S", 8);
    gameValues.put("9S", 9);
    gameValues.put("10S", 10);
    gameValues.put("JS", 10);
    gameValues.put("QS", 10);
    gameValues.put("KS", 10);
    gameValues.put("AS", 11);
  }

  static {
    suiteValues = new HashMap<>();
    suiteValues.put("C", 2);
    suiteValues.put("D", 1);
    suiteValues.put("H", 3);
    suiteValues.put("S", 4);
  }
}
