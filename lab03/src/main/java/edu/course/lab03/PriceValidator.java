package edu.course.lab03;

/**
 * Общая проверка цены для политик и калькулятора.
 */
final class PriceValidator {

    private PriceValidator() {
    }

    static void requireValidPrice(double price) {
        if (!Double.isFinite(price) || price < 0) {
            throw new IllegalArgumentException("price must be a finite non-negative number");
        }
    }
}
