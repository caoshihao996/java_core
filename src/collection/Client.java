package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class Client {

    private String name;

    private ArrayList<BankAccount> accounts;

    public Client(String initName){
        this.name = initName;
        this.accounts = new ArrayList<BankAccount>();
    }

    public String getName(){
        return name;
    }

    public void addAccount(BankAccount bankAccount){
        this.accounts.add(bankAccount);
    }

    public Iterator<BankAccount> iterator(){
        return this.accounts.iterator();
    }

    public int getNumberOfAccounts(){
        return this.accounts.size();
    }

    public ArrayList<BankAccount> getAccounts(){
        return this.accounts;
    }
}
