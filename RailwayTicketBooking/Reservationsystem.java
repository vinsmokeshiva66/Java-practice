import java.util.*;

public class Reservationsystem {
    public static int Tickerid=1;
    public int seat_number=1;
    static List<Train>trains=new ArrayList<>();
    static List<Ticket>tickets=new ArrayList<>();
    public Ticket ticket;

    public void bookTicket(int train_number,int seats,String class_type,String name,int age,String gender){
        for(Train t:trains){
            if(t.getTrainnumber()==train_number && class_type.equals("AC")){
                if(t.getAcseats()>=seats){
                    t.setAcseats(seats);
                    ticket.generateTicket(Tickerid,name,class_type, seat_number, seats);
                    seat_number+=seats;
                    System.out.println("You Ticket has been booked with the ID :"+Tickerid);
                    @SuppressWarnings("unused")
                    Passenger p=new Passenger(name, age, gender,Tickerid);
                    Tickerid++;
                }else{
                    System.out.println("No AC tickets has been available for the Train :"+t.getTrainnumber());
                }
            }else if(t.getTrainnumber()==train_number && class_type.equals("Sleeper")){
                if(t.getSleeperseats()<=seats){
                    t.setAcseats(seats);
                    ticket.generateTicket(Tickerid,name,class_type, seat_number, seats);
                    seat_number+=seats;
                    System.out.println("You Ticket has been booked with the ID :"+Tickerid);
                    @SuppressWarnings("unused")
                    Passenger p=new Passenger(name, age, gender,Tickerid);
                    Tickerid++;
                }else{
                    System.out.println("No Sleeper tickets has been available for the Train :"+t.getTrainnumber());
                }
            }else{
                System.out.println("Something Fishy!!!");
            }
        }
    }

    public void display_tickets(int tickedId){
        for(Ticket t:tickets){
            if(tickedId==t.getTickerid()){
                t.ticket_details();
            }
        }
    }
}
