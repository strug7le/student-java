package edu.course.lab03;

/**
 * Политика скидки, применяемая к цене.
 */
public interface DiscountPolicy {

    /**
     * Применяет скидку к цене.
     *
     * @param price неотрицательная цена
     * @return цена после скидки
     */
    double apply(double price);
}
