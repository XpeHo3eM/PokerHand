package ru.mail.npv90;

import ru.mail.npv90.pokerHand.hand.PokerHand;
import ru.mail.npv90.pokerHand.ranking.RankingHands;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RankingHands hands = new RankingHands(Arrays.asList(new PokerHand("2C 3C AC 4C 5C"),
                new PokerHand("KS 2H 5H JS TH"),
                new PokerHand("AD QD KD JD TD"),
                new PokerHand("2D 4S TS JC 8H"),
                new PokerHand("7S 7C 7D 7H AH")));

        System.out.println("Before");
        System.out.println(hands);

        Collections.sort(hands.getHands());

        System.out.println("Sorted");
        System.out.println(hands);
    }
}
