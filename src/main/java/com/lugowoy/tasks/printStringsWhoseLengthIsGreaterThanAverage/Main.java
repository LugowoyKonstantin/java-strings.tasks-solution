package com.lugowoy.tasks.printStringsWhoseLengthIsGreaterThanAverage;

import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.Array;
import com.lugowoy.helper.other.LengthReader;

/**
 * Print strings whose length is greater than the average of the arithmetic length.
 * <p>
 * Created by LugowoyKonstantin on 20.08.2018.
 */

public class Main {

    private static final int LENGTH_STRING = 30;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthOfArray = LengthReader.readLength(new ReadingConsole());

        Array<String> stringArray = new Array<>(new FillingArrayRandomLengthValueStrings("english").fill(lengthOfArray, LENGTH_STRING));

        System.out.println("Strings in an array : " + stringArray);

        double valueOfArithmeticMeanLengthOfAllStrings = calculateArithmeticMeanOfLengthsOfAllStrings(stringArray);
        System.out.println("Result arithmetic mean of length of all strings : " + valueOfArithmeticMeanLengthOfAllStrings);

        System.out.println("Strings that are greater than the average of the lengths of all strings : ");
        printStringsWhoseLengthIsGreaterThanAverage(stringArray, valueOfArithmeticMeanLengthOfAllStrings);

    }

    private static void printStringsWhoseLengthIsGreaterThanAverage(Array<String> stringArray, double valueArithmeticMean) {
        for (int i = 0; i < stringArray.getLength(); i++) {
            String value = stringArray.get(i);
            if (value.length() > valueArithmeticMean) {
                System.out.print(value + " ");
            }
        }
    }

    private static double calculateArithmeticMeanOfLengthsOfAllStrings(Array<String> stringArray) {
        double resultToCalculateArithmeticMean = 0;
        for (int i = 0; i < stringArray.getLength(); i++) {
            resultToCalculateArithmeticMean += stringArray.get(i).length();
        }
        return resultToCalculateArithmeticMean / stringArray.getLength();
    }

}
