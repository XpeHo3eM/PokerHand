package ru.mail.npv90.pokerHand.hand;

import ru.mail.npv90.exception.IncorrectDistributionException;
import ru.mail.npv90.pokerHand.card.Card;

import java.util.Arrays;
import java.util.List;

public class PokerHandValidator {
    private static final int distributionCorrectLength = PokerHand.cardCount * Card.cardSize + (PokerHand.cardCount - 1);

    public static void validate(String distribution) throws IncorrectDistributionException {
        if (distribution.length() != distributionCorrectLength) {
            throw new IncorrectDistributionException(String.format("Некорректный размер раздачи: %d, ожидалось: %d",
                    distribution.length(),
                    distributionCorrectLength));
        }

        List<String> cards = Arrays.stream(distribution.split(PokerHand.delimiter)).toList();

        if (cards.size() != PokerHand.cardCount) {
            throw new IncorrectDistributionException(String.format("Некорректное количество карт: %d, ожидалось: %d",
                    cards.size(),
                    PokerHand.cardCount));
        }

        if (cards.stream().distinct().toList().size() != cards.size()) {
            throw new IncorrectDistributionException("Имеются дубликаты карт");
        }
    }
}
