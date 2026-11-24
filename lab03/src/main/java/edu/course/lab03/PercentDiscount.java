package edu.course.lab03;

/**
 * Политика процентной скидки.
 */
public class PercentDiscount implements DiscountPolicy {

    private final double percent;

    /**
     * @param percent процент скидки от 0 до 100 включительно
     * @throws IllegalArgumentException если процент вне диапазона или не является конечным числом
     */
    public PercentDiscount(double percent) {
        if (!Double.isFinite(percent) || percent < 0 || percent > 100) {
            throw new IllegalArgumentException("percent must be between 0 and 100");
        }
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        PriceValidator.requireValidPrice(price);
        return price * (100.0 - percent) / 100.0;
    }
}
