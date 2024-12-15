import java.util.*;

public class User {
    public String userId;
    private String userName;
    public List<Book>users=new ArrayList<>();

    public User(String userName){
        this.userId=UUID.randomUUID().toString();
        this.userName=userName;
    }

    public void borrowBook(Book book){
        users.add(book);
    }

    public void returnBook(Book book){
        users.remove(book);
    }
}
