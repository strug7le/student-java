package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void constructorStoresInitialBalance() {
        BankAccount account = new BankAccount(100);

        assertEquals(100, account.getBalance());
    }

    @Test
    void constructorAllowsZeroBalance() {
        BankAccount account = new BankAccount(0);

        assertEquals(0, account.getBalance());
    }

    @Test
    void constructorRejectsNegativeBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-1));
    }

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount(100);

        account.deposit(50);

        assertEquals(150, account.getBalance());
    }

    @Test
    void depositRejectsZeroAmount() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertEquals(100, account.getBalance());
    }

    @Test
    void depositRejectsNegativeAmount() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
        assertEquals(100, account.getBalance());
    }

    @Test
    void depositRejectsOverflow() {
        BankAccount account = new BankAccount(Integer.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(1));
        assertEquals(Integer.MAX_VALUE, account.getBalance());
    }

    @Test
    void withdrawDecreasesBalance() {
        BankAccount account = new BankAccount(100);

        account.withdraw(30);

        assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawRejectsAmountGreaterThanBalance() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(101));
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawAllowsFullBalance() {
        BankAccount account = new BankAccount(100);

        account.withdraw(100);

        assertEquals(0, account.getBalance());
    }

    @Test
    void withdrawRejectsZeroAmount() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawRejectsNegativeAmount() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
        assertEquals(100, account.getBalance());
    }

    @Test
    void keepsBalanceAfterSeveralOperations() {
        BankAccount account = new BankAccount(500);

        account.deposit(250);
        account.withdraw(300);
        account.withdraw(50);

        assertEquals(400, account.getBalance());
    }
}
