package edu.course.lab03;

/**
 * Политика без скидки.
 */
public class NoDiscount implements DiscountPolicy {

    @Override
    public double apply(double price) {
        PriceValidator.requireValidPrice(price);
        return price;
    }
}
