import java.util.*;

public class Wallet extends Transaction{
    Map<User,Double>wallet_balance=new HashMap<>();
    public String curr_type="";
    public double curr_amount=0.00;

    public Wallet(){
        super(0.00,"");
    }

    public Wallet(String curr_type,double curr_amount){
        super(curr_amount,curr_type);
    }

    public void add_money(User user,double amount){
        wallet_balance.put(user,wallet_balance.get(user)+amount);
        curr_type="Credit";
        curr_amount=wallet_balance.get(user);
        @SuppressWarnings("unused")
		Wallet transaction=new Wallet(curr_type, amount);
    }

    @SuppressWarnings("unused")
    public void withdraw(User user,double amount){
        double curr_balance=wallet_balance.get(user);
        if(curr_balance>=amount){
            wallet_balance.put(user,wallet_balance.get(user)-amount);
            System.out.println("Amount withdrawn successfully");
            curr_type="Debit";
            curr_amount=wallet_balance.get(user);
            Wallet transaction=new Wallet(curr_type, amount);
        }else{
            System.out.println("Insufficient balance");
        }
    }
    public double check_balance(User user){
        return wallet_balance.get(user);
    }

    public void addusers(User user){
        if(user!=null) wallet_balance.put(user,0.00);
    }
}
