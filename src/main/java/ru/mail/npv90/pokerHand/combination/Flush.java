package ru.mail.npv90.pokerHand.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;
import java.util.Set;

public class Flush implements Combination {
    @Override
    public boolean isCombination(List<Card> hand) {
        char suit = hand.get(0).getSuit();

        return hand.stream()
                .allMatch(card -> (card.getSuit() == suit));
    }
}
