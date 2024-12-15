import java.util.*;
import java.sql.*;

public class Accounts {
    private Connection connection;
    private Scanner scanner;

    public Accounts(Scanner scanner,Connection connection){
        this.connection=connection;
        this.scanner=scanner;
    }

    public long open_account(String email){
        if(!account_exist(email)){
            String open_account_query="INSERT INTO Accounts(account_number,full_name,email,balance,security_pin) VALUES(?,?,?,?,?)";
            scanner.nextLine();
            System.out.print("Enter Full Name: ");
            String full_name=scanner.nextLine();
            System.out.print("Enter Initial Amount: ");
            double balance=scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter Security Pin: ");
            String security_pin=scanner.nextLine();
            try{
                long account_number=generateAccountNumber();
                PreparedStatement pre=connection.prepareStatement(open_account_query);
                pre.setLong(1,account_number);
                pre.setString(2,full_name);
                pre.setString(3, email);
                pre.setDouble(4, balance);
                pre.setString(5,security_pin);
                int rows_affected=pre.executeUpdate();
                if(rows_affected>0){
                    return account_number;
                }else{
                    throw new RuntimeException("Account Creation failed!!");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Account Already Exist");
    }

    public long getAccount_number(String email){
        String query="SELECT account_number FROM Accounts WHERE email=?";
        try{
            PreparedStatement pre=connection.prepareStatement(query);
            pre.setString(1, email);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                return rs.getLong("account_number");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
    }

    private long generateAccountNumber(){
        try{
            String query="SELECT account_number FROM Accounts ORDER BY DESC LIMIT 1";
            PreparedStatement pre=connection.prepareStatement(query);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                long last_account_number=rs.getLong("account_number");
                return last_account_number+1;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return 10000100;
    }

    public boolean account_exist(String email){
        String query="SELECT * FROM Accounts WHERE email=?";
        try{
            PreparedStatement pre=connection.prepareStatement(query);
            pre.setString(1,email);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
