package ru.mail.npv90.pokerHand.card.combination;

import lombok.Getter;
import lombok.Setter;
import ru.mail.npv90.pokerHand.card.Card;

import java.util.List;

@Getter
@Setter
public abstract class Combination {
    int power;

    abstract boolean isExists(List<Card> hand);
}
