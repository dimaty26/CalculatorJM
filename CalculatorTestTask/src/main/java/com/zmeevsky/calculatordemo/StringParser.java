package com.zmeevsky.calculatordemo;

import java.util.HashSet;
import java.util.Set;

public class StringParser {

    private static String[] validateString(String string) {

        if (string.isBlank()) {
            throw new EmptyStringExcpetion("Empty input. Please provide valid input information.");
        }

        String[] strings = string.replace(" ", "").split("-|\\+|\\*|\\/");

        if (strings.length != 2) {
            throw new InvalidStringProvidedException("You should provide only 2 positive numbers and sign: +, -, * or /.");
        }

        return strings;
    }

    public String[] parseString(String string) {

        String[] result = new String[4];

        if (string.contains("+")) {
            result[2] = "+";
        } else if (string.contains("-")) {
            result[2] = "-";
        } else if (string.contains("*")) {
            result[2] = "*";
        } else {
            result[2] = "/";
        }

        String[] strings = validateString(string);

        if (isValidDigit(strings[0]) && isValidDigit(strings[1])) {
            result[0] = strings[0];
            result[1] = strings[1];
            result[3] = "Arabic";
        } else if (isValidRoman(strings[0]) && isValidRoman(strings[1])) {
            result[0] = strings[0];
            result[1] = strings[1];
            result[3] = "Roman";
        } else {
            throw new InvalidStringProvidedException("Wrong input. Please provide valid input info.\n" +
                    "Do not use arabic and roman numbers simultaneously.\n" +
                    "Numbers should not be more than 10.");
        }

        return result;
    }

    private static boolean isValidDigit(String str) {

        Set<String> strToIntSet = new HashSet<>();
        strToIntSet.add("1");
        strToIntSet.add("2");
        strToIntSet.add("3");
        strToIntSet.add("4");
        strToIntSet.add("5");
        strToIntSet.add("6");
        strToIntSet.add("7");
        strToIntSet.add("8");
        strToIntSet.add("9");
        strToIntSet.add("10");

        for (String s : strToIntSet) {
            if (str.equals(s)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isValidRoman(String str) {

        Set<String> strToRomanSet = new HashSet<>();
        strToRomanSet.add("I");
        strToRomanSet.add("II");
        strToRomanSet.add("III");
        strToRomanSet.add("IV");
        strToRomanSet.add("V");
        strToRomanSet.add("VI");
        strToRomanSet.add("VII");
        strToRomanSet.add("VIII");
        strToRomanSet.add("IX");
        strToRomanSet.add("X");

        for (String s : strToRomanSet) {
            if (str.equals(s)) {
                return true;
            }
        }

        return false;
    }
}
