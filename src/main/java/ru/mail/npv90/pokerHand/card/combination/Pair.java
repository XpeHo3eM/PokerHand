package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair extends Combination {
    private final Map<Character, Integer> duplicates = new HashMap<>();

    public Pair(int power) {
        setPower(power);
    }

    @Override
    public boolean isExists(List<Card> hand) {
        duplicates.clear();

        hand.stream()
                .map(Card::getValue)
                .forEach(value -> duplicates.put(value, duplicates.getOrDefault(value, 0) + 1));

        return duplicates.values().stream()
                .filter(count -> count == 2)
                .count() == 1;
    }
}
