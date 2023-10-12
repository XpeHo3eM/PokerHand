package ru.mail.npv90.pokerHand.hand;


import lombok.Getter;
import ru.mail.npv90.exception.IncorrectDistribution;
import ru.mail.npv90.exception.IncorrectPokerHand;
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

    public PokerHand(String distribution) throws IncorrectPokerHand {
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
    public int compareTo(PokerHand o) {
        int thisPower = CombinationSearcher.findCombination(hand).getPower();
        int otherPower = CombinationSearcher.findCombination(o.hand).getPower();

        return otherPower - thisPower;
    }

    @Override
    public String toString() {
        return String.format("Hand: %s, Combination: %s\n", hand, CombinationSearcher.getCombination(this));
    }
}
