package org.bubblesort;
import org.example.bubblesort.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    void testIntegers() {
        //Given
        List<Comparable> input = List.of(1, 4, 5, 6, 8, 3, 8);
        //When
        BubbleSort bs = new BubbleSort();
        List<Comparable> result = bs.sort(input);
        //Then
        List<Comparable> expectedResult = List.of(1, 3, 4, 5, 6, 8, 8);
        assertEquals(expectedResult, result);
    }

    @Test
    void testDoubles() {
        //Given
        List<Comparable> input = List.of(-9.3, 0.2, 4, 0.1, 5, 9);
        //When
        BubbleSort bs = new BubbleSort();
        List<Comparable> result = bs.sort(input);
        //Then
        List<Comparable> expectedResult = List.of(-9.3, 0.1, 0.2, 4, 5, 9);
        assertEquals(expectedResult, result);
    }

    @Test
    void testEmptyInput() {
        //Given
        List<Comparable> input = List.of();
        //When
        BubbleSort bs = new BubbleSort();
        List<Comparable> result = bs.sort(input);
        //Then
        List<Comparable> expectedResult = List.of();
        assertEquals(expectedResult, result);
    }

    @Test
    void testListWithNull() {
        //Given
        List<Comparable> input = new ArrayList<>();
        input.add(null);
        input.add(5.0001);
        //When
        BubbleSort bs = new BubbleSort();
        List<Comparable> result = bs.sort(input);
        //Then
        List<Comparable> expectedResult = List.of(5.0001);
        assertEquals(expectedResult, result);
    }

    @Test
    void testNullInput() {
        //Given
        List<Comparable> input = null;
        BubbleSort bs = new BubbleSort();
        //When
        //Then
        assertThrows(RuntimeException.class, () -> bs.sort(input));
    }
}
