package ru.mail.npv90.pokerHand.card;

import lombok.Getter;
import ru.mail.npv90.exception.IncorrectCardException;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
public class Card implements Comparable<Card> {
    public static final int cardSize = 2;
    public static final Map<Character, Integer> availableValues = Stream.of(new Object[][]{
            {'2', 0},
            {'3', 1},
            {'4', 2},
            {'5', 3},
            {'6', 4},
            {'7', 5},
            {'8', 6},
            {'9', 7},
            {'T', 8},
            {'J', 9},
            {'Q', 10},
            {'K', 11},
            {'A', 12}
    }).collect(Collectors.toMap(data -> (Character) data[0], data -> (Integer) data[1]));
    public static final Set<Character> availableSuits = Set.of('S', 'H', 'D', 'C');

    private final Character value;
    private final int valuePower;
    private final Character suit;

    public Card(String card) throws IncorrectCardException {
        CardValidator.validate(card);

        this.value = Character.toUpperCase(card.charAt(0));
        this.valuePower = availableValues.get(value);
        this.suit = Character.toUpperCase(card.charAt(1));
    }

    @Override
    public String toString() {
        return String.format("%s%s", value, suit);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;

        if (!value.equals(card.value)) return false;
        return suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        int result = value.hashCode();
        result = 31 * result + suit.hashCode();
        return result;
    }

    @Override
    public int compareTo(Card other) {
        return valuePower - other.valuePower;
    }
}
