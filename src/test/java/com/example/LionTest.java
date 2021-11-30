package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Pekhov A.V.
 * @created 30/11/2021 - 08:43
 */

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Mock
    static Feline feline;

    static Stream<Arguments> stringArrayProvider() {

        return Stream.of(
                Arguments.arguments("Самец", true),
                Arguments.arguments("Самка", false)
        );
    }

    @ParameterizedTest
    @MethodSource("stringArrayProvider")
    public void testHasMane(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMore = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMore);
    }

    @Test
    public void shouldBeSexException() {
        assertThrows(Exception.class, () -> new Lion("Трансгендер", feline));
    }

    @Test
    public void shouldBeGetKittens() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int expectedKittensCount = 1;
        assertEquals(expectedKittensCount, lion.getKittens());
    }

    @Test
    public void shouldGetFood() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }

}
