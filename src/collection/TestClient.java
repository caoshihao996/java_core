package collection;

import java.io.PrintWriter;
import java.util.Iterator;

public class TestClient {

    private static PrintWriter stdOut = new PrintWriter(System.out, true);
    private static PrintWriter stErr = new PrintWriter(System.err, true);

    public static void main(String[] args){
        BankAccount accountOne = new BankAccount();
        BankAccount accoutTwo = new BankAccount();
        BankAccount accountThree = new BankAccount();

        accountOne.deposit(1000.0);
        accoutTwo.deposit(2000.0);
        accountThree.deposit(3000.0);

        Client client = new Client("John Smith");

        client.addAccount(accountOne);
        client.addAccount(accoutTwo);
        client.addAccount(accountThree);

        double totalBalance = 0.0;
        /*for(BankAccount account:client.getAccounts()){
            totalBalance+=account.getBalance();
        }*/
        BankAccount account = new BankAccount();
        Iterator<BankAccount> iterator = client.iterator();
        while (iterator.hasNext()){
            account = iterator.next();
            stdOut.println(account.getBalance());
            totalBalance+=account.getBalance();
        }

        if(totalBalance!=6000.0){
            stErr.println("**test failure");
        }
        stdOut.println("done");
    }
}
