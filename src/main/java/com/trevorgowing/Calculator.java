package com.trevorgowing;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

class Calculator {

  boolean calculateWinner(List<Card> handA, List<Card> handB) {
    Integer valueA = handA.stream()
        .mapToInt(Card::getGameValue)
        .sum();

    Integer valueB = handB.stream()
        .mapToInt(Card::getGameValue)
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

  private boolean calculateHighestCardWinner(List<Card> handA, List<Card> handB) {
    handA.sort(Collections.reverseOrder());
    handB.sort(Collections.reverseOrder());

    int minLength = Math.min(handA.size(), handB.size());
    for (int i = 0; i < minLength; i++) {
      Card cardA = handA.get(i);
      Card cardB = handB.get(i);
      int gameValueComparisonComparison = Integer.compare(cardA.getGameValue(), cardB.getGameValue());
      if (gameValueComparisonComparison != 0)  {
        return gameValueComparisonComparison > 0;
      } else {
        int cardRankComparison = Integer.compare(cardA.getCardRank(), cardB.getCardRank());
        if (cardRankComparison != 0) {
          return cardRankComparison > 0;
        }
      }
    }
    return calculateSuiteWinner(handA, handB);
  }

  private boolean calculateSuiteWinner(List<Card> handA, List<Card> handB) {
    return true;
  }
}
