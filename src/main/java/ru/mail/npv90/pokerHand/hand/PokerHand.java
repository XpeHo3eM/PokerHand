package ru.mail.npv90.pokerHand.hand;


import lombok.Getter;
import ru.mail.npv90.exception.IncorrectCardException;
import ru.mail.npv90.exception.IncorrectDistributionException;
import ru.mail.npv90.exception.IncorrectPokerHandException;
import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.card.combination.CombinationSearcher;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PokerHand implements Comparable<PokerHand> {
    public static final int cardCount = 5;
    public static final String delimiter = " ";
    private final List<Card> hand;
    private final int handPower;

    public PokerHand(String distribution) throws IncorrectPokerHandException {
        try {
            PokerHandValidator.validate(distribution);

            hand = Arrays.stream(distribution.split(delimiter))
                    .toList()
                    .stream()
                    .map(Card::new)
                    .sorted(Card::compareTo)
                    .collect(Collectors.toList());
        } catch (IncorrectDistributionException | IncorrectCardException e) {
            throw new IncorrectPokerHandException(e.getMessage());
        }

        handPower = CombinationSearcher.findCombination(hand).getPower();
    }

    @Override
    public int compareTo(PokerHand o) {
        return o.handPower - this.handPower;
    }

    @Override
    public String toString() {
        return String.format("Hand: %s, Combination: %s\n", hand, CombinationSearcher.getCombination(this));
    }
}
