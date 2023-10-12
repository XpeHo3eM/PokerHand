package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;

public class Flush extends Combination {
    public Flush(int power) {
        setPower(power);
    }

    @Override
    public boolean isExists(List<Card> hand) {
        char suit = hand.get(0).getSuit();

        return hand.stream()
                .allMatch(card -> (card.getSuit() == suit));
    }
}
