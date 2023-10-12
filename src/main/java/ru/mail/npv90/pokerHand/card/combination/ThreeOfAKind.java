package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeOfAKind extends Combination {
    private final Map<Character, Integer> duplicates = new HashMap<>();

    public ThreeOfAKind(int power) {
        setPower(power);
    }
    @Override
    public boolean isExists(List<Card> hand) {
        duplicates.clear();

        hand.stream()
                .map(Card::getValue)
                .forEach(value -> duplicates.put(value, duplicates.getOrDefault(value, 0) + 1));

        return duplicates.values()
                .stream()
                .anyMatch(count -> count == 3);
    }
}
