package ru.mail.npv90.pokerHand.hand;


import ru.mail.npv90.exception.IncorrectDistribution;
import ru.mail.npv90.exception.IncorrectPokerHand;
import ru.mail.npv90.pokerHand.card.Card;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHand implements Comparable {
    public static final int cardCount = 5;
    public static final String delimiter = " ";
    private final List<Card> hand;

    PokerHand(String distribution) throws IncorrectPokerHand {
        try {
            PokerHandValidator.validate(distribution);
        } catch (IncorrectDistribution e) {
            throw new IncorrectPokerHand(e.getMessage());
        }

        hand = Arrays.stream(distribution.split(delimiter))
                .toList()
                .stream()
                .map(Card::new)
                .sorted(Card::compareTo)
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
