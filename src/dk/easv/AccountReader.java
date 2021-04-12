package dk.easv;

public class AccountReader implements Runnable {
    IAccount account;

    public AccountReader(IAccount a) {
        account = a;
    }

    @Override
    public void run() {
        try {
            Double balance = account.getBalance();
            System.out.println("Balance from Reader: " + balance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
