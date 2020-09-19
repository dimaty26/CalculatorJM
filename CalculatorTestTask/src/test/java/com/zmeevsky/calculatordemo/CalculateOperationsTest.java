package com.zmeevsky.calculatordemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateOperationsTest {

    @Test
    @DisplayName("Addition Test")
    void shouldReturnResultOfAddition() {
        int resultOfAddition = CalculateOperations.add(3, 4);
        assertEquals(7, resultOfAddition);
    }

    @Test
    @DisplayName("Subtraction Test")
    void shouldReturnResultOfSubtraction() {
        int resultOfSubtraction = CalculateOperations.subtract(8, 4);
        assertEquals(4, resultOfSubtraction);
    }

    @Test
    @DisplayName("Multiplication Test")
    void shouldReturnResultOfMultiplication() {
        int resultOfMultiplication = CalculateOperations.multiply(3, 4);
        assertEquals(12, resultOfMultiplication);
    }

    @Test
    @DisplayName("Division Test")
    void shouldReturnResultOfDivision() {
        int resultOfDivision = CalculateOperations.divide(12, 3);
        assertEquals(4, resultOfDivision);
    }
}