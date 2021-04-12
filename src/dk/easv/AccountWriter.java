package dk.easv;

public class AccountWriter implements Runnable {

    private boolean isDone = false;
    private IAccount account;

    public AccountWriter(IAccount a) {
        account = a;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2000; i++) {
            account.changeBalance(1);
        }
        isDone = true;
    }

    public boolean getIsDone() {
        return isDone;
    }
}
