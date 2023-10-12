package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouse extends Combination {
    private final Map<Character, Integer> duplicates = new HashMap<>();

    public FullHouse(int power) {
        setPower(power);
    }
    @Override
    public boolean isExists(List<Card> hand) {
        duplicates.clear();

        hand.stream()
                .map(Card::getValue)
                .forEach(value -> duplicates.put(value, duplicates.getOrDefault(value, 0) + 1));

        boolean pair = false;
        boolean threeOfAKind = false;

        for (int value : duplicates.values()) {
            if (value == 2) {
                pair = true;
            }
            if (value == 3) {
                threeOfAKind = true;
            }
        }

        return pair && threeOfAKind;
    }
}
