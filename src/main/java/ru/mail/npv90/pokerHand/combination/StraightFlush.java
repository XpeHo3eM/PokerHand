package ru.mail.npv90.pokerHand.combination;

import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.List;

public class StraightFlush implements Combination {
    @Override
    public boolean isCombination(List<Card> hand) {
        char suit = hand.get(0).getSuit();

        if (!hand.stream().allMatch(card -> card.getSuit() == suit)) {
            return false;
        }

        int lowCardPower = Card.availableValues.get(hand.get(0).getValue());

        int totalPower = hand.stream()
                .mapToInt(card -> Card.availableValues.get(card.getValue()))
                .sum();
        totalPower -= lowCardPower * PokerHand.cardCount;

        return totalPower == 10;
    }
}
