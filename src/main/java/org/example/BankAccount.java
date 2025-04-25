package org.example;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {

    private final AtomicInteger id;

    private final AtomicInteger balance;

    public BankAccount(int id, int balance) {
        this.id = new AtomicInteger(id);
        this.balance = new AtomicInteger(balance);
    }

    public void deposit(int count) {
        balance.getAndAdd(count);
        System.out.println("Успешное пополнение счёта.");
    }

    public void withdraw(int count) {
        if (balance.get() >= count) {
            balance.getAndAdd(-count);
            System.out.println("Успешное снятие со счёта.");
        } else {
            System.out.println("На балансе нехватает средств.");
        }
    }

    public int getBalance() {
        return balance.get();
    }

    public AtomicInteger getId() {
        return id;
    }
}
