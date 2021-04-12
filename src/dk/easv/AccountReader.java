package dk.easv;

public class AccountReader implements Runnable {
    IAccount account;

    public AccountReader(IAccount a) {
        account = a;
    }

    @Override
    public void run() {
        Double balance = account.getBalance();
        System.out.println("Balance from Reader: " + balance);
    }
}
