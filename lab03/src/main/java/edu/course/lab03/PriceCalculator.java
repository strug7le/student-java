package edu.course.lab03;

/**
 * Применяет переданную политику скидки к цене.
 */
public class PriceCalculator {

    private final DiscountPolicy discountPolicy;

    /**
     * @param discountPolicy политика скидки
     * @throws IllegalArgumentException если политика равна {@code null}
     */
    public PriceCalculator(DiscountPolicy discountPolicy) {
        if (discountPolicy == null) {
            throw new IllegalArgumentException("discount policy must not be null");
        }
        this.discountPolicy = discountPolicy;
    }

    /**
     * Считает итоговую цену с помощью переданной политики.
     *
     * @param price неотрицательная цена
     * @return цена после применения скидки
     */
    public double calculate(double price) {
        PriceValidator.requireValidPrice(price);
        return discountPolicy.apply(price);
    }
}
