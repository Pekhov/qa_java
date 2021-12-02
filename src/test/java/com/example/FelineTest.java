package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pekhov A.V.
 * @created 30/11/2021 - 14:46
 */

public class FelineTest {

    @Test
    public void getFamilyCorrectReturnTest() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void shouldBeReturnOneKittens() {
        Feline feline = new Feline();
        int expectedKittens = 1;
        assertEquals(expectedKittens, feline.getKittens());
    }

}
