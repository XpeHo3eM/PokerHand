package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;
import java.util.Set;

public class FlushRoyal extends Combination {
    private final Set<Character> availableValues = Set.of('T', 'J', 'Q', 'K', 'A');

    public FlushRoyal(int power) {
        setPower(power);
    }

    @Override
    public boolean isExists(List<Card> hand) {
        char suit = hand.get(0).getSuit();

        return hand.stream()
                .allMatch(card -> (card.getSuit() == suit) && availableValues.contains(card.getValue()));
    }
}
