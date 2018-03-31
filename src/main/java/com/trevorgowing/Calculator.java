package com.trevorgowing;

import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

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
    OptionalInt valueA = handA.stream()
        .mapToInt(Card::getGameValue)
        .max();

    OptionalInt valueB = handB.stream()
        .mapToInt(Card::getGameValue)
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

  private boolean calculateSuiteWinner(List<Card> handA, List<Card> handB) {
    return true;
  }
}
