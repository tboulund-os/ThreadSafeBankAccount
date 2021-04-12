package dk.easv;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        IAccount account = new SimpleAccount();
        //IAccount account = new AccountWithTransactionsAsArrayList();
        //IAccount account = new AccountWithTransactionsAsHashMap();

        for (int i = 0; i < 1000; i++) {
            account.changeBalance(1);
        }
        Double balance = account.getBalance();

        System.out.println("Balance from Main: " + balance);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        AccountReader reader = new AccountReader(account);
        AccountWriter writer1 = new AccountWriter(account);
        AccountWriter writer2 = new AccountWriter(account);

        executor.submit(writer1);
        executor.submit(writer2);
        while(!writer1.getIsDone() || !writer2.getIsDone()) {
            Thread.sleep(50);
        }

        executor.submit(reader);
        executor.shutdown();
    }
}
