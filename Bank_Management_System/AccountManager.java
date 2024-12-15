import java.sql.*;
import java.util.*;

public class AccountManager {
    private Connection connection;
    private Scanner scanner;

    AccountManager(Scanner scanner,Connection connection){
        this.connection=connection;
        this.scanner=scanner;
    }

    public void credit_money(long account_number) throws SQLException{
        scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Security Pin: ");
        String security_pin=scanner.nextLine();

        try{
            connection.setAutoCommit(false);
            if(account_number!=0){
                String query="SELECT * FROM Acounts WHERE account_number=? AND security_pin=?";
                PreparedStatement pre=connection.prepareStatement(query);
                pre.setLong(1,account_number);
                pre.setString(2,security_pin);
                ResultSet rs=pre.executeQuery();

                if(rs.next()){
                    String credit_query="UPDATE Accounts SET balance=balance+? WHERE account_number=?";
                    PreparedStatement pre1= connection.prepareStatement(credit_query);
                    pre1.setDouble(1, amount);
                    pre1.setLong(2,account_number);
                    int rows_affected=pre1.executeUpdate();
                    if(rows_affected>0){
                        System.out.println("Rs. "+amount+"Credit Succesfully");
                        connection.commit();
                        connection.setAutoCommit(true);
                        return;
                    }else{
                        System.out.println("Transaction Failed!");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }
                }
            }else{
                System.out.println("Invalid pin");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

    public void getBalance(long account_number){
        scanner.nextLine();
        System.out.println("Enter Security Pin: ");
        String security_pin=scanner.nextLine();

        try{
            String query="SELECT balance FROM Accounts WHERE account_number=? AND security_pin=?";
            PreparedStatement pre=connection.prepareStatement(query);
            pre.setLong(1,account_number);
            pre.setString(2,security_pin);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                double balance=rs.getDouble("balance");
                System.out.println("Balance: "+balance);
            }else{
                System.out.println("Invalid Pin");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void debit_money(long account_number) throws SQLException{
        scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount=scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter security_pin: ");
        String security_pin=scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if(account_number!=0){
                String query="SELECT balance FROM Accounts WHERE account_number=? AND security_pin=?";
                PreparedStatement pre=connection.prepareStatement(query);
                pre.setLong(1,account_number);
                pre.setString(2,security_pin);
                ResultSet rs=pre.executeQuery();
                if(rs.next()){
                    double current_balance=rs.getDouble("balance");
                    if(amount<=current_balance){
                        String debit_query="UPDATE Account SET balance=balance-? WHERE account_number=?";
                        PreparedStatement pre1=connection.prepareStatement(debit_query);
                        pre1.setDouble(1, current_balance);
                        pre1.setLong(2,account_number);
                        int rows_affected=pre1.executeUpdate();
                        if(rows_affected>0){
                            System.out.println("Rs."+amount+" debited Successfully");
                            connection.commit();
                            connection.setAutoCommit(true);
                            return;
                        }else{
                            System.out.print("Transaction Failed");
                            connection.rollback();
                            connection.setAutoCommit(true);
                        }
                    }else{
                        System.out.println("Insufficient balance");
                    }
                }
            }else{
                System.out.println("Invalid pin");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        connection.setAutoCommit(true);
    }

    public void transfer_money(long sender_account_number) throws SQLException{
        scanner.nextLine();
        System.out.print("Enter Receiver Account Number: ");
        long receiver_account_number=scanner.nextLong();
        System.out.print("Enter Amount: ");
        double amount=scanner.nextDouble();
        System.out.print("Enter Security_pin: ");
        String security_pin=scanner.nextLine();
        try{
            connection.setAutoCommit(false);
            if(sender_account_number!=0 && receiver_account_number!=0){
                String query="SELECT * FROM Accounts WHERE account_number=? AND security_pin=?";
                PreparedStatement pre=connection.prepareStatement(query);
                pre.setLong(1,sender_account_number);
                pre.setString(2,security_pin);
                ResultSet rs=pre.executeQuery();
                if(rs.next()){
                    double current_balance=rs.getDouble("balance");
                    if(amount<=current_balance){
                        String debit_query="UPDATE Accounts SET balance=balance-? WHERE account_number=?";
                        String credit_query="UPDATE Accounts SET balance=balance+? WHERE account_number=?";

                    PreparedStatement pre1=connection.prepareStatement(debit_query);
                    PreparedStatement pre2=connection.prepareStatement(credit_query);

                    pre1.setDouble(1, amount);
                    pre1.setLong(2,sender_account_number);
                    pre2.setDouble(1, amount);
                    pre2.setLong(2,receiver_account_number);
                    int rows_affected1=pre1.executeUpdate();
                    int rows_affected2=pre2.executeUpdate();
                    if(rows_affected1>0 && rows_affected2>0){
                        System.out.println("Transaction Successful");
                        System.out.println("Rs."+amount+" Transferred Successfully");
                        connection.commit();
                        connection.setAutoCommit(true);
                        return;
                    }else{
                        System.out.println("Transaction Failed !!");
                        connection.rollback();
                        connection.setAutoCommit(true);
                    }         
                }else{
                    System.out.println("Insufficient Balance");
                }
            }else{
                System.out.println("Invalid Security_pin");
            }
        }else{
            System.out.println("Invalid Account_number");
        }
    }catch(Exception e){
        e.printStackTrace();
    }
}
}