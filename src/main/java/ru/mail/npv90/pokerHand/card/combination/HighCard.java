package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;

public class HighCard extends Combination {
    public HighCard(int power) {
        setPower(power);
    }
    @Override
    public boolean isExists(List<Card> hand) {
        return true;
    }
}
