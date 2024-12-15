import java.sql.*;
public class DatabaseManager {
    private Connection connection;

    public DatabaseManager() throws SQLException{
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagement","root","password");

    }

    public void addProduct(String name,double price,int stock) throws SQLException{
        String query="INSERT INTO Products (name,price,stock) VALUES(?,?,?)";
        try(PreparedStatement pre=connection.prepareStatement(query)){
            pre.setString(1, name);
            pre.setDouble(2, price);
            pre.setInt(3, stock);
            pre.executeUpdate();
            System.out.println("Product added successfully!");
        }
    }

    public void viewProducts() throws SQLException{
        String query="SELECT * FROM Products";
        try{
            Statement st=connection.createStatement();
            ResultSet rs=st.executeQuery(query);
            System.out.println("\nAvailable Products:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("product_id") + ", Name: " + rs.getString("name") + ", Price: " + rs.getDouble("price") + ", Stock: " + rs.getInt("stock"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public synchronized void purchaseProduct(int productId,int quantity){
        String checkQuery="SELECT stock FROM Products WHERE product_id=?";
        try{
            PreparedStatement pre=connection.prepareStatement(checkQuery);
            pre.setInt(1,productId);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){
                int current_stock=rs.getInt("Stock");
                if(current_stock>=quantity){
                    String updateQuery="UPDATE Products SET stock=stock-? WHERE product_id=?";
                    try{
                        PreparedStatement pre1=connection.prepareStatement(updateQuery);
                        pre1.setInt(1,quantity);
                        pre1.setInt(2,productId);
                        pre1.executeUpdate();
                        System.out.println("Purchase successful! Product ID: " + productId + ", Quantity: " + quantity);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("Insufficient stock for Product ID: " + productId);
                }
            }else{
                System.out.println("Product ID not found.");
            }  
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
