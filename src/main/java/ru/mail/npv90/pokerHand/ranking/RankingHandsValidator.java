package ru.mail.npv90.pokerHand.ranking;

import ru.mail.npv90.exception.DuplicateCardException;
import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RankingHandsValidator {
    private static final Set<Card> usedCards = new HashSet<>();

    public static void validate(List<PokerHand> hands) {
        hands.forEach(pokerHand -> {
            pokerHand.getHand().forEach(card -> {
                if (usedCards.contains(card)) {
                    throw new DuplicateCardException(String.format("Дубль карты: %s", card));
                }

                usedCards.add(card);
            });
        });
    }
}
