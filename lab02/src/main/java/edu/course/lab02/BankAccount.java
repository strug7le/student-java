package edu.course.lab02;

/**
 * Банковский счет с защищенным балансом.
 */
public class BankAccount {

    private int balance;

    /**
     * Создает счет с заданным начальным балансом.
     *
     * @param initialBalance неотрицательный начальный баланс
     * @throws IllegalArgumentException если начальный баланс отрицателен
     */
    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("initial balance must not be negative");
        }
        this.balance = initialBalance;
    }

    /**
     * Пополняет счет на положительную сумму.
     *
     * @param amount сумма пополнения
     * @throws IllegalArgumentException если сумма неположительна или баланс переполняется
     */
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("deposit amount must be positive");
        }
        if (amount > Integer.MAX_VALUE - balance) {
            throw new IllegalArgumentException("balance must not overflow");
        }
        balance += amount;
    }

    /**
     * Списывает положительную сумму, не превышающую баланс.
     *
     * @param amount сумма списания
     * @throws IllegalArgumentException если сумма неположительна или превышает баланс
     */
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("insufficient funds");
        }
        balance -= amount;
    }

    /**
     * Возвращает текущий баланс.
     */
    public int getBalance() {
        return balance;
    }
}
