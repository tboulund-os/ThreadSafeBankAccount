package dk.easv;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TransactionalAccountHashMap implements IAccount {
    private final Map<UUID, Double> transactions = new HashMap<>();

    @Override
    public double getBalance() {
        Double balance = 0.0;

        for (Double amount : transactions.values()) {
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
        transactions.put(UUID.randomUUID(), amount);
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
