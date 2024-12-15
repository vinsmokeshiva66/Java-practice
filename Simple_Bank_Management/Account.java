import java.util.UUID;

public class Account{
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String name){
        this.accountHolderName=name;
        this.accountNumber=UUID.randomUUID().toString();
        this.balance=0.00;
    }

    public String getaccountNumber(){
        return accountNumber;
    }

    public String getaccountHolderName(){
        return accountHolderName;
    }

    public double getbalance(){
        return balance;
    }

    public void deposit(double amount){
        balance+=amount;
    }

    public boolean withdraw(double amount){
        if(balance>=amount){
            balance-=amount;
            return true;
        }
        return false;
    }

    public String toString() {
        return "Account{" +
                "AccountNumber='" + accountNumber + '\'' +
                ", AccountHolderName='" + accountHolderName + '\'' +
                ", Balance=" + balance +
                '}';
    }
}