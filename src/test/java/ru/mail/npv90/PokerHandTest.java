package ru.mail.npv90;

import org.junit.jupiter.api.Test;
import ru.mail.npv90.exception.IncorrectPokerHand;
import ru.mail.npv90.pokerHand.card.combination.CombinationSearcher;
import ru.mail.npv90.pokerHand.hand.PokerHand;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class PokerHandTest {
    @Test
    public void shouldGetExceptionIncorrectCardValue() {
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand(""),
                "Создалась рука с пустыми картами");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("2C 3C 4C 5C 6С 7С"),
                "Создалась рука с большим количеством карт");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("2C 3C 4C 5C"),
                "Создалась рука с 4 картами");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("2C 3C 4C 5C 6Q"),
                "Создалась рука с некорректной мастью");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("1C 3C 4C 5C 6С"),
                "Создалась рука с некорректным значением");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("2C 3C 4C 5 C"),
                "Создалась рука с некорректной картой");
        assertThrows(IncorrectPokerHand.class, () -> new PokerHand("2C 2C 4C 5С 6C"),
                "Создалась рука с повторяющейся картой");
    }

    @Test
    public void shouldCreatePokerHand() {
        assertDoesNotThrow(() -> new PokerHand("AD QD KD JD TD"),
                "Не создалась корректная рука");
    }

    @Test
    public void shouldSortHands() {
        PokerHand hand1 = new PokerHand("KS 2H 5C JD TD");
        PokerHand hand2 = new PokerHand("AD QD KD JD TD");
        PokerHand hand3 = new PokerHand("3S 3C 3D 3H AH");

        List<PokerHand> hands = Arrays.asList(hand1, hand2, hand3);
        Collections.sort(hands);

        List<PokerHand> correctSortedHands = List.of(hand2, hand3, hand1);

        assertEquals(correctSortedHands, hands, "Некорректная сортировка");
    }

    @Test
    public void shouldGetCorrectCombinationFlushRoyal() {
        PokerHand hand = new PokerHand("AD QD KD JD TD");

        assertEquals("FlushRoyal", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationStraightFlush() {
        PokerHand hand = new PokerHand("2D 3D 4D 5D 6D");

        assertEquals("StraightFlush", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationFourOfAKind() {
        PokerHand hand = new PokerHand("2D 2C 2H 2S 3D");

        assertEquals("FourOfAKind", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationFullHouse() {
        PokerHand hand = new PokerHand("2D 2C 2H KD KS");

        assertEquals("FullHouse", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationFlush() {
        PokerHand hand = new PokerHand("2D QD 6D 7D 3D");

        assertEquals("Flush", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationStraight() {
        PokerHand hand = new PokerHand("2D 3H 4D 5S 6C");

        assertEquals("Straight", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationThreeOfAKind() {
        PokerHand hand = new PokerHand("2D 2H 2C 7D 3D");

        assertEquals("ThreeOfAKind", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationTwoPairs() {
        PokerHand hand = new PokerHand("2D 2C KC KS 3D");

        assertEquals("TwoPairs", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationPair() {
        PokerHand hand = new PokerHand("2D 2S 6D 7D 3D");

        assertEquals("Pair", CombinationSearcher.getCombination(hand));
    }

    @Test
    public void shouldGetCorrectCombinationHighCard() {
        PokerHand hand = new PokerHand("2D TS 6D 7D 3D");

        assertEquals("HighCard", CombinationSearcher.getCombination(hand));
    }
}
