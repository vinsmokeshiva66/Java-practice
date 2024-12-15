import java.sql.*;
import java.util.*;

public class User {
    private Connection connection;
    private Scanner scanner;

    public User(Scanner scanner,Connection connection){
        this.connection=connection;
        this.scanner=scanner;
    }

    public void register(){
        scanner.nextLine();
        System.out.print("Full Name: ");
        String full_name=scanner.nextLine();
        System.out.print("Email: ");
        String email=scanner.nextLine();
        System.out.print("Password: ");
        String password=scanner.nextLine();
        if(user_exist(email)){
            System.out.println("User Already Exist !!");
            return;
        }
        String register_query="INSERT INTO user(fullname,email,password) VALUES(?,?,?)";
        try{
            PreparedStatement pre=connection.prepareStatement(register_query);
            pre.setString(1, full_name);
            pre.setString(2, email);
            pre.setString(3, password);
            int rows_affected=pre.executeUpdate();
            if(rows_affected>0){
                System.out.println("Registration successful");
            }else{
                System.out.println("Registration failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String login(){
        scanner.nextLine();
        System.out.print("Email: ");
        String email=scanner.nextLine();
        System.out.print("Password: ");
        String password=scanner.nextLine();
        String login_query="SELECT * FROM user WHERE email=? AND password=?";
        try{
            PreparedStatement pre=connection.prepareStatement(login_query);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                System.out.println("Login sucessful");
                return email;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Login failed";
    }

    public boolean user_exist(String email){
        String query="select * from user where email=?";
        try{
            PreparedStatement pre=connection.prepareStatement(query);
            pre.setString(1,email);
            ResultSet rs=pre.executeQuery();
            if(rs.next()) return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
