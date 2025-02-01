import java.util.*;

public class Reservation_system {
    static int Passenger_id=1;
    static List<Flight>total_flights=new ArrayList<>();
    static List<Passenger>booked_Passengers=new ArrayList<>();


    public void book(int flight_id,int seats){
        Flight isready=isflight(flight_id, seats);
        if(isready!=null){
            int price=isready.getPrice()*seats; 
            int increment=seats*200;
            isready.setPrice(increment);
            Passenger p1=new Passenger(seats,isready.getFlight_id(),price,Passenger_id++);
            booked_Passengers.add(p1);
            System.out.println("Ticket successfully booked with Passenger ID:"+p1.getPassenger_id());
            return;
        }
        System.out.println("Flight or seat not available");
    }

    public void cancel(int passenger_Id,int flight_Id){
        Passenger isready=getPassenger(passenger_Id);
        Flight isready1=geFlight(flight_Id);
        if(isready!=null){
            int booked_seats=isready.getBooked_seats();
            int decrement_price=isready1.getPrice()-booked_seats*200;
            isready1.setPrice(decrement_price);
            System.out.println("Refunded amount!!!!!!:"+isready.getPrice_booked());
            booked_Passengers.remove(isready);
            System.out.println("Ticket cancelled successfully");
            return;
        }
        System.out.println("Passenger ID is wrong");
    }

    public Flight isflight(int flight_id,int seats){
        for(Flight f:total_flights){
            if(f.getFlight_id()==flight_id && f.getTotal_seats()>=seats) return f;
        }
        return null;
    }

    public Passenger getPassenger(int passenger_Id){
        for(Passenger p :booked_Passengers){
            if(p.getPassenger_id()==passenger_Id) return p;
        }
        return null;
    }

    public Flight geFlight(int flight_Id){
        for(Flight f:total_flights){
            if(f.getFlight_id()==flight_Id) return f;
        }
        return null;
    }

    public void Ticketdetails(){
        for(Passenger p: booked_Passengers){
            System.out.println(p.getTicketdetails());
        }
        return;
    }
}
