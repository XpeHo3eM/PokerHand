package ru.mail.npv90.pokerHand.combination;

import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;

public interface Combination {
    boolean isCombination(List<Card> hand);
}
