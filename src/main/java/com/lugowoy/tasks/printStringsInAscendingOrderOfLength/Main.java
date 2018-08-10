package com.lugowoy.tasks.printStringsInAscendingOrderOfLength;

import com.lugowoy.helper.factory.FactoryArray;
import com.lugowoy.helper.factory.creator.CreatorArrayUnknown;
import com.lugowoy.helper.filling.array.strings.FillingArrayRandomLengthValueStrings;
import com.lugowoy.helper.io.reading.ReadingConsole;
import com.lugowoy.helper.models.arrays.Array;
import com.lugowoy.helper.other.ArrayLength;

/** Created by Konstantin Lugowoy on 09.08.2018. */

public class Main {

    private static final int BOUND_STRINGS_LENGTH = 30;

    public static void main(String[] args) {

        System.out.println("Enter length of the array : ");
        int lengthArray = ArrayLength.getLengthArray(new ReadingConsole());

        Array<String> stringsArray = FactoryArray.getFactoryArray(new CreatorArrayUnknown<String>()).create(
                                                                      new FillingArrayRandomLengthValueStrings("english").fill(lengthArray,
                                                                                                                                       BOUND_STRINGS_LENGTH));

        System.out.println("Strings in an array : " + stringsArray);

        printNumbersInAscendingOrdersOfLength(stringsArray);

        System.out.println("Result : " + stringsArray);

    }

    private static void printNumbersInAscendingOrdersOfLength(Array<String> stringsArray) {
        boolean toSort = true;
        while (toSort) {
            toSort = false;
            for (int j = 0; j < stringsArray.getLength() - 1; j++) {
                if (stringsArray.get(j).length() > stringsArray.get(j + 1).length()) {
                    String tmp = stringsArray.get(j + 1);
                    stringsArray.set(j + 1, stringsArray.get(j));
                    stringsArray.set(j, tmp);
                    toSort = true;
                }
            }
        }
    }

}
