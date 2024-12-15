import java.util.*;

public class User{
    @SuppressWarnings("unused")
    private String User_Id;
    protected String name;
    private Wallet wallet;

    public User(String name){
        this.User_Id=UUID.randomUUID().toString();
        this.name=name;
        this.wallet=new Wallet();
    }
    public String getname(){
        return name;
    }

    public void setname(String name){
        this.name=name;
    }

    public Wallet getWallet(){
        return wallet;
    }
    public String getUsers(){
        return "User{" +
                "username='" + name + '\'' +
                '}';
    }

    public boolean register_user(String name){
        if(getUsers().contains(name)){
            System.out.print("User already registered");
            return false;
        }
        User newuser=new User(name);
        wallet.addusers(newuser);
        System.out.print("User added");
        return true;
    }
}