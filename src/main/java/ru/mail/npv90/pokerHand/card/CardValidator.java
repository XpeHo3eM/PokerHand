package ru.mail.npv90.pokerHand.card;

import ru.mail.npv90.exception.IncorrectCardException;


public class CardValidator {
    public static void validate(String card) throws IncorrectCardException {
        if (card.length() != Card.cardSize) {
            throw new IncorrectCardException(String.format("Некорректная карта в раздаче: %s", card));
        }

        char value = Character.toUpperCase(card.charAt(0));
        char suit = Character.toUpperCase(card.charAt(1));

        if (!Card.availableValues.containsKey(value)) {
            throw new IncorrectCardException(String.format("Карта содержит некорректное значение: %s", value));
        }
        if (!Card.availableSuits.contains(suit)) {
            throw new IncorrectCardException(String.format("Карта содержит некорректную масть: %s", suit));
        }
    }
}
