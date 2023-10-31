package ru.mail.npv90.pokerHand.ranking;

import lombok.Getter;
import ru.mail.npv90.exception.DuplicateCardException;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.List;

@Getter
public class RankingHands {
    private List<PokerHand> hands;

    public RankingHands(List<PokerHand> hands) throws DuplicateCardException {
        RankingHandsValidator.validate(hands);

        this.hands = hands;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        hands.forEach(pokerHand -> {
            sb.append(pokerHand.toString());
        });

        return sb.toString();
    }
}
