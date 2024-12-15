import java.util.*;

public class Library {
    private Map<String,Book>books=new HashMap<>();
    private Map<String,User>users=new HashMap<>();

    public String addBook(String title,String author){
        Book book=new Book(title,author);
        books.put(book.BookId,book);
        return "Book added successfully";
    }

    public String registerUser(String name){
        User user=new User(name);
        users.put(user.userId,user);
        return "User added successfully";
    }

    public boolean lendBook(String userId,String bookId){
        Book book=books.get(bookId);
        User user=users.get(userId);
        if(book!=null && user!=null){
            book.lendBook(book);
            if(!book.isavailable){
                System.out.println("Book has been lended");
                user.borrowBook(book);
                return true;
            }
        }
        System.out.println("Book currently not available");
        return false;
    }

    public boolean returnBook(String userId,String bookId){
        Book book=books.get(bookId);
        User user=users.get(userId);
        if(book!=null && user!=null){
            book.returnBook(book);
            if(book.isavailable){
                System.out.print("Book has been returned");
                user.returnBook(book);
                return true;
            }
        }
        System.out.println("Book not returend");
        return false;
    }

    public String getBookDetails(String stringId){
        Book book=books.get(stringId);
        return book.getBookDetails();
    }

    public String getUserDetails(String userId){
        User user=users.get(userId);
        return user.toString();
    }
}
