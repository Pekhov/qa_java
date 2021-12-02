package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    public void shouldBeExceptionWhenSexIncorrect() {
        assertThrows(Exception.class, () -> new Lion("Трансгендер", feline));
    }

    @Test
    public void shouldBeReturnTwoKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittensCount = 2;
        Mockito.when(feline.getKittens()).thenReturn(2);
        assertEquals(expectedKittensCount, lion.getKittens());
    }

    @Test
    public void shouldBeReturnListOfFood() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood());
    }

}
