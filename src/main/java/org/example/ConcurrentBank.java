package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentBank {

    private AtomicInteger count = new AtomicInteger(0);

    private final ConcurrentHashMap<AtomicInteger,BankAccount> accountStorage = new ConcurrentHashMap<>();


    public BankAccount createAccount(int count) {
        BankAccount account = new BankAccount(this.count.incrementAndGet(), count);
        accountStorage.put(new AtomicInteger(this.count.get()),account);
        return account;
    }

    public void transfer(BankAccount from, BankAccount to, int count) {
        from.withdraw(count);
        to.deposit(count);
    }

    public int getTotalBalance() {
        AtomicInteger total = new AtomicInteger();
        for (Map.Entry<String, BankAccount> entry : accountStorage.entrySet()) {
            total.addAndGet(entry.getValue().getBalance());
        }
        return total.get();
    }
}
