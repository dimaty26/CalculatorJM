package com.zmeevsky.calculatordemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorApplication {

    public static void main(String[] args) throws IOException {

        ConsoleHelper.printInitInfo();
        Calculator calculator = new Calculator();
        StringParser stringParser = new StringParser();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String stringFromConsole;

            while (!"exit".equalsIgnoreCase(stringFromConsole = reader.readLine())) {

                System.out.println(calculator.calculate(stringParser.parseString(stringFromConsole)));
            }
        }
    }
}
