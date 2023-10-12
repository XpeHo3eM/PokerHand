package ru.mail.npv90.pokerHand.card;

import ru.mail.npv90.exception.IncorrectCard;


public class CardValidator {
    public static boolean isValid(String card) throws IncorrectCard {
        if (card.length() != Card.cardSize) {
            throw new IncorrectCard(String.format("Некорректная карта в раздаче: %s", card));
        }

        char value = card.charAt(0);
        char suit = card.charAt(1);

        if (!Card.availableValues.containsKey(value)) {
            throw new IncorrectCard(String.format("Карта содержит некорректное значение: %s", value));
        }
        if (!Card.availableSuits.contains(suit)) {
            throw new IncorrectCard(String.format("Карта содержит некорректную масть: %s", suit));
        }

        return true;
    }
}
