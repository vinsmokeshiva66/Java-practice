import java.util.*;

public class Book {
    public String BookId;
    private String title;
    private String author;
    public boolean isavailable;

    public Book(String title,String author){
        this.title=title;
        this.author=author;
        this.BookId=UUID.randomUUID().toString();
        this.isavailable=true;
    }

    public String getBookDetails(){
        return "BookDetails{" +
                "BookId='" + BookId + '\'' +
                ", Title='" + title + '\'' +
                ", Author=" + author +
                ", Availability=" + isavailable +
                '}';
    }

    public void lendBook(Book book){
        this.isavailable=false;
    }

    public void returnBook(Book book){
        this.isavailable=true;
    }
}
