package org.example.bubblesort;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {
    public List<Comparable> sort(List<Comparable> input) {
        if (input == null) {
            throw new RuntimeException();
        }
        List<Comparable> resultList = new ArrayList<>(checkAndDeleteNulls(input));
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < resultList.size() - 1; i++) {
                Comparable<Number> firstElement = resultList.get(i);
                Comparable<Number> secondElement = resultList.get(i + 1);
                double one = mapToDouble(resultList.get(i));
                double two = mapToDouble(resultList.get(i + 1));
                if (one > two) {
                    Comparable<Number> temp = secondElement;
                    secondElement = firstElement;
                    firstElement = temp;
                    resultList.set(i, firstElement);
                    resultList.set(i + 1, secondElement);
                    flag = true;
                }
            }
        }
        return resultList;
    }

    private double mapToDouble(Comparable<Number> num) {
        return Double.parseDouble(num.toString());
    }

    private List<Comparable> checkAndDeleteNulls(List<Comparable> input) {
        for (Comparable element : input) {
            if (element == null) {
                input.remove(null);
            }
        }
        return input;
    }
}
