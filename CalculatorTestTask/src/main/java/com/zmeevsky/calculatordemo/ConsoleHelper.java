package com.zmeevsky.calculatordemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    public static void printInitInfo() {
        System.out.println("This is Calculator.");
        System.out.println("You may use only 2 arabic and roman numbers up to 10.");
        System.out.println("You may use only positive integer numbers.");
        System.out.println("You may use +, -, *, / operations.");
        System.out.println("In order to stop program print \"exit\"");
        System.out.println("Print your expression: ");
    }
}
