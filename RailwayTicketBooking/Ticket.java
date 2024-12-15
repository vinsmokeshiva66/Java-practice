import java.util.*;

public class Ticket {
    private int tickedId;
    private String class_type;
    private int total_seats;
    List<Integer>seat_number=new ArrayList<>();
    private String name;


    public void generateTicket(int tickedId,String name,String class_type,int seat_numbers,int total_seat){
        this.tickedId=tickedId;
        this.name=name;
        this.class_type=class_type;
        this.total_seats=total_seat;
        while(total_seat>0){
            seat_number.add(seat_numbers++);
        }
        Reservationsystem.tickets.add(new Ticket());
    }

    public int getTickerid(){
        return tickedId;
    }

    public String ticket_details(){
        return "Ticket_Id :"+tickedId +"class_type :"+class_type +"Total_seats :"+total_seats+"Seat_numbers :"+seat_number.toString()+"Name"+name;
    }
}
