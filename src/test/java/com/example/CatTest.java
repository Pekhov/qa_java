package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Pekhov A.V.
 * @created 30/11/2021 - 07:44
 */

public class CatTest {

    Feline feline;
    Cat cat;

    @BeforeEach
    public void setUp() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void getSoundCorrectReturnTest() {
        String expectedSound = "Мяу";
        assertEquals(expectedSound, cat.getSound());
    }

    @Test
    public void shouldGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, cat.getFood());
    }
}
