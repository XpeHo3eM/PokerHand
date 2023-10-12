package ru.mail.npv90.pokerHand.hand;

import ru.mail.npv90.exception.IncorrectCard;
import ru.mail.npv90.exception.IncorrectDistribution;
import ru.mail.npv90.pokerHand.card.Card;
import ru.mail.npv90.pokerHand.card.CardValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokerHandValidator {
    private static final int distributionCorrectLength = PokerHand.cardCount * Card.cardSize + (PokerHand.cardCount - 1);

    public static void validate(String distribution) throws IncorrectDistribution {
        if (distribution.length() != distributionCorrectLength) {
            throw new IncorrectDistribution(String.format("Некорректный размер раздачи: %d, ожидалось: %d",
                    distribution.length(),
                    distributionCorrectLength));
        }

        List<String> cards = Arrays.stream(distribution.split(PokerHand.delimiter)).toList();

        if (cards.size() != PokerHand.cardCount) {
            throw new IncorrectDistribution(String.format("Некорректное количество карт: %d, ожидалось: %d",
                    cards.size(),
                    PokerHand.cardCount));
        }

        try {
            cards.stream()
                    .allMatch(CardValidator::isValid);
        } catch (IncorrectCard e) {
            throw new IncorrectDistribution(e.getMessage());
        }

        if (cards.stream().distinct().toList().size() != cards.size()) {
            throw new IncorrectDistribution("Имеются дубликаты карт");
        }
    }
}
