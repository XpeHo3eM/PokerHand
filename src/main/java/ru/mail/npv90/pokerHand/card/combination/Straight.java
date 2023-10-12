package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.Collections;
import java.util.List;

public class Straight extends Combination {
    public Straight(int power) {
        setPower(power);
    }
    @Override
    public boolean isExists(List<Card> hand) {
        int lowCardPower = Card.availableValues.get(hand.get(0).getValue());

        int totalPower = hand.stream()
                .mapToInt(card -> Card.availableValues.get(card.getValue()))
                .sum();
        totalPower -= lowCardPower * PokerHand.cardCount;

        long uniquePowers = hand.stream()
                .mapToInt(card -> Card.availableValues.get(card.getValue()))
                .distinct()
                .count();

        return totalPower == 10 && uniquePowers == PokerHand.cardCount;
    }
}
