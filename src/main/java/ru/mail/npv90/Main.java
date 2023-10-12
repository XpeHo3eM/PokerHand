package ru.mail.npv90;

import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<PokerHand> hands = Arrays.asList(new PokerHand("2C 3C AC 4C 5C"),
                new PokerHand("KS 2H 5C JD TD"),
                new PokerHand("AD QD KD JD TD"),
                new PokerHand("2C 4C TS JC 8H"),
                new PokerHand("3S 3C 3D 3H AH"));

        System.out.println("Before");
        System.out.println(hands);

        Collections.sort(hands);

        System.out.println("Sorted");
        System.out.println(hands);
    }
}
