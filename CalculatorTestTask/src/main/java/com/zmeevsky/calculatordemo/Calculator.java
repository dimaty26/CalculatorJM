package com.zmeevsky.calculatordemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculator {

    public String calculate(String[] massiveAfterParsing) {

        if ("Arabic".equals(massiveAfterParsing[3])) {
            return calculateArabic(massiveAfterParsing);
        } else {
            return calculateRoman(massiveAfterParsing);
        }

    }

    private static int getOperationNum(String[] massive) {

        if ("+".equals(massive[2])) {
            return 1;
        } else if ("-".equals(massive[2])) {
            return 2;
        } else if ("*".equals(massive[2])) {
            return 3;
        } else {
            return 4;
        }
    }

    private static String calculateArabic(String[] massive) {

        int operationNum = getOperationNum(massive);

        int a = Integer.parseInt(massive[0]);
        int b = Integer.parseInt(massive[1]);

        return String.valueOf(calculate(a, b, operationNum));
    }

    private static String calculateRoman(String[] massive) {

        int operationNum = getOperationNum(massive);

        int a = convertFromRomanToInt(massive[0]);
        int b = convertFromRomanToInt(massive[1]);

        return arabicToRoman(calculate(a, b, operationNum));
    }

    private static int convertFromRomanToInt(String string) {

        Map<String, Integer> toIntMap = new HashMap<>();
        toIntMap.put("I", 1);
        toIntMap.put("II", 2);
        toIntMap.put("III", 3);
        toIntMap.put("IV", 4);
        toIntMap.put("V", 5);
        toIntMap.put("VI", 6);
        toIntMap.put("VII", 7);
        toIntMap.put("VIII", 8);
        toIntMap.put("IX", 9);
        toIntMap.put("X", 10);

        for (Map.Entry<String, Integer> entry : toIntMap.entrySet()) {
            if (string.equals(entry.getKey())) {
                return entry.getValue();
            }
        }

        return 0;
    }

    private static int calculate(int a, int b, int operationNum) {

        if (operationNum == 1) {
            return CalculateOperations.add(a, b);
        } else if (operationNum == 2) {
            return CalculateOperations.subtract(a, b);
        } else if (operationNum == 3) {
            return CalculateOperations.multiply(a, b);
        } else {
            return CalculateOperations.divide(a, b);
        }
    }

    private static String arabicToRoman(int number) {

        int i = 0;
        StringBuilder sb = new StringBuilder();

        if (number < 0) {
            number = Math.abs(number);
            sb.append("-");
        }

        List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

        while ((number > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }

        return sb.toString();
    }
}
