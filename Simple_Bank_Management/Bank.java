import java.util.*;

public class Bank{
    private Map<String,Account>accounts=new HashMap<>();

    public String createAccount(String accountHolderName){
        Account newaccount=new Account(accountHolderName);
        accounts.put(newaccount.getaccountNumber(),newaccount);
        return newaccount.getaccountNumber();
    }

    public String getAccountDetails(String accountNumber){
        Account account=accounts.get(accountNumber);
        if(account==null){
            return "Account not found";
        }else{
            return account.toString();
        }
    }

    public String depositToAccount(String accountNumber,double amount){
        Account account=accounts.get(accountNumber);
        if(account!=null){
            account.deposit(amount);
            return "Depsit success";
        }else{
            return "account not found";
        }
    }

    public String withdrawFromAccount(String accountNumber,double amount){
        Account account=accounts.get(accountNumber);
        if(account!=null){
            if(account.withdraw(amount)){
                return "Withdraw sucess";
            }else{
                return "Insufficient balance";
            }
        }else{
            return "Account not found";
        }
    }

    public String checkBalance(String accountNumber){
        Account account=accounts.get(accountNumber);
        if(account!=null){
            return "Current Balance"+" "+account.getbalance();
        }
        return "Account not found";

    }
}