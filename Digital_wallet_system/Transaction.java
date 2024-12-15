import java.util.*;

public class Transaction{
    private String transactionId;
    private double amount;
    private String type;
    private long timestamp;

    public Transaction(double amount,String type){
        this.transactionId=UUID.randomUUID().toString();
        this.amount=amount;
        this.type=type;
        this.timestamp=System.currentTimeMillis();
    }
    
    public String Transaction_detail(){
        return "User{" +
                "TransactionId='" + transactionId + '\'' +
                "Amount='" + amount + '\'' +
                "Type of Transaction='" + type + '\'' +
                "Timestamp='" + timestamp + '\'' +
                '}';
    }
}
