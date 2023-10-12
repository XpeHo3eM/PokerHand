package ru.mail.npv90.pokerHand.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeOfAKind implements Combination {
    private final Map<Character, Integer> duplicates = new HashMap<>();

    @Override
    public boolean isCombination(List<Card> hand) {
        hand.stream()
                .map(Card::getValue)
                .forEach(value -> duplicates.put(value, duplicates.getOrDefault(value, 0) + 1));

        return duplicates.values()
                .stream()
                .anyMatch(count -> count == 3);
    }
}
