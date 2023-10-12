package ru.mail.npv90.pokerHand.card.combination;

import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.List;
import java.util.Map;

public class CombinationSearcher {
    private static final Map<Combination, String> combinations = Map.of(new FlushRoyal(9), "FlushRoyal",
            new StraightFlush(8), "StraightFlush",
            new FourOfAKind(7), "FourOfAKind",
            new FullHouse(6), "FullHouse",
            new Flush(5), "Flush",
            new Straight(4), "Straight",
            new ThreeOfAKind(3), "ThreeOfAKind",
            new TwoPairs(2), "TwoPairs",
            new Pair(1), "Pair",
            new HighCard(0), "HighCard");

    public static Combination findCombination(List<Card> hand) {
        return combinations.keySet().stream()
                .sorted((Combination a, Combination b) -> b.power - a.power)
                .filter(combination -> combination.isExists(hand))
                .toList()
                .get(0);
    }

    public static String getCombination(PokerHand pokerHand) {
        return combinations.get(findCombination(pokerHand.getHand()));
    }
}
