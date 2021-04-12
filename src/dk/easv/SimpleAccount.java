package dk.easv;

public class SimpleAccount implements IAccount {
    // Without synchronizing access to the balance we get inconsistent results
    private double balance = 0;

    @Override
    public double getBalance() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    @Override
    public synchronized void changeBalance(double amount) {
        balance += amount;
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
