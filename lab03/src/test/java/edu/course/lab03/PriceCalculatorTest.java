package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PriceCalculatorTest {

    @Test
    void calculatesPriceWithNoDiscount() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());

        assertEquals(100.0, calculator.calculate(100.0), 1e-9);
    }

    @Test
    void calculatesPriceWithPercentDiscount() {
        PriceCalculator calculator = new PriceCalculator(new PercentDiscount(20));

        assertEquals(80.0, calculator.calculate(100.0), 1e-9);
    }

    @Test
    void replacesDiscountPolicyWithoutChangingClientCode() {
        assertEquals(100.0, calculateWith(new NoDiscount(), 100.0), 1e-9);
        assertEquals(80.0, calculateWith(new PercentDiscount(20), 100.0), 1e-9);
    }

    @Test
    void rejectsNullPolicy() {
        assertThrows(IllegalArgumentException.class, () -> new PriceCalculator(null));
    }

    @Test
    void rejectsNegativePrice() {
        PriceCalculator calculator = new PriceCalculator(new NoDiscount());

        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(-1.0));
    }

    private static double calculateWith(DiscountPolicy policy, double price) {
        return new PriceCalculator(policy).calculate(price);
    }
}
