package collection;

public class BankAccount {

    private double balance;

    public BankAccount(){
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount){
        if(amount>0){
            this.balance+=amount;
            return true;
        }else{
            return false;
        }
    }
}
