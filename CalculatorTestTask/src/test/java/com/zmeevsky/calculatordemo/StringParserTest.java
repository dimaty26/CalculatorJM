package com.zmeevsky.calculatordemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class StringParserTest {

    private final StringParser stringParser = new StringParser();

    @Test
    @DisplayName("InvalidStringProvidedException Test")
    void shouldReturnInvalidStringProvidedException() {
        assertThrows(InvalidStringProvidedException.class, () -> stringParser.parseString("1 & 7"));
        assertThrows(InvalidStringProvidedException.class, () -> stringParser.parseString("2 & II"));
        assertThrows(InvalidStringProvidedException.class, () -> stringParser.parseString("1 + 3 - 4"));
        assertThrows(InvalidStringProvidedException.class, () -> stringParser.parseString("1 + 72"));
        assertThrows(InvalidStringProvidedException.class, () -> stringParser.parseString("II & XX"));
    }

    @Test
    @DisplayName("EmptyStringException Test")
    void shouldReturnEmptyStringException() {
        assertThrows(EmptyStringExcpetion.class, () -> stringParser.parseString("    "));
        assertThrows(EmptyStringExcpetion.class, () -> stringParser.parseString(""));
    }
}