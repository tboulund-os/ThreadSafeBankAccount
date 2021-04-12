package dk.easv;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TransactionalAccountArrayList implements IAccount {
    private final List<Double> transactions = new CopyOnWriteArrayList<>();

    @Override
    public double getBalance() {
        Double balance = 0.0;
        for (Double amount : transactions) {
            balance += amount;
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return balance;
    }

    @Override
    public void changeBalance(double amount) {
        transactions.add(amount);
    }
}
