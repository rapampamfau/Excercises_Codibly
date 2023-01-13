package org.wordscounter;

import org.example.wordscounter.BalancedWordsCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BalancedWordsCounterTest {

    @Test
    void testInputForLettersOnly() {
        //Given
        String input = "aabbabcccba";
        BalancedWordsCounter bws = new BalancedWordsCounter();
        //When
        int result = bws.count(input);
        //Then
        assertEquals(28, result);
    }

    @Test
    void testEmptyInput() {
        //Given
        String input = "";
        BalancedWordsCounter bws = new BalancedWordsCounter();
        //When
        int result = bws.count(input);
        //Then
        assertEquals(0, result);
    }

    @Test
    void testInputWithNull() {
        //Given
        String input = null;
        BalancedWordsCounter bwc = new BalancedWordsCounter();
        //When&Then
        assertThrows(RuntimeException.class, () -> bwc.count(input));
    }

    @Test
    void testInputNotOnlyWithLetters() {
        //Given
        String input = "abababa1";
        BalancedWordsCounter bwc = new BalancedWordsCounter();
        //When&Then
        assertThrows(RuntimeException.class, () -> bwc.count(input));
    }
}
