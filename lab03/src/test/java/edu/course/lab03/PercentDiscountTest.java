package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PercentDiscountTest {

    @Test
    void appliesTwentyPercentDiscount() {
        PercentDiscount policy = new PercentDiscount(20);

        assertEquals(80.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void appliesZeroPercentDiscount() {
        PercentDiscount policy = new PercentDiscount(0);

        assertEquals(100.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void appliesFullDiscount() {
        PercentDiscount policy = new PercentDiscount(100);

        assertEquals(0.0, policy.apply(100.0), 1e-9);
    }

    @Test
    void rejectsPercentBelowZero() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(-0.1));
    }

    @Test
    void rejectsPercentAboveHundred() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(100.1));
    }

    @Test
    void rejectsNonFinitePercent() {
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> new PercentDiscount(Double.POSITIVE_INFINITY));
    }

    @Test
    void rejectsNegativePrice() {
        PercentDiscount policy = new PercentDiscount(20);

        assertThrows(IllegalArgumentException.class, () -> policy.apply(-1.0));
    }
}
