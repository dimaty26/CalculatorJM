package com.zmeevsky.calculatordemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void shouldReturnCorrectResult() {
        assertEquals("-3", calculator.calculate(new String[]{"1", "4", "-", "Arabic"}));
        assertEquals("-III", calculator.calculate(new String[]{"I", "IV", "-", "Roman"}));
    }

}