package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NoDiscountTest {

    private final NoDiscount policy = new NoDiscount();

    @Test
    void returnsOriginalPrice() {
        assertEquals(100.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void returnsZeroForZeroPrice() {
        assertEquals(0.0, policy.apply(0.0), 1e-9);
    }

    @Test
    void rejectsNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> policy.apply(-1.0));
    }
}
