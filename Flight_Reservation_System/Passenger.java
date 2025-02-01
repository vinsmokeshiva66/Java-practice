public class Passenger {
    int booked_seats;
    int flight_Id;
    int price_booked;
    int Passenger_id;

    public Passenger(int booked_seats,int flight_Id,int price_booked,int Passenger_id){
        this.booked_seats=booked_seats;
        this.flight_Id=flight_Id;
        this.price_booked=price_booked;
        this.Passenger_id=Passenger_id;
    }


    public int getPrice_booked(){
        return price_booked;
    }

    public int getFlight_id(){
        return flight_Id;
    }

    public int getBooked_seats(){
        return booked_seats;
    }

    public int getPassenger_id(){
        return Passenger_id;
    }

    public String getTicketdetails(){
        return "Passenger_ID:"+Passenger_id+"\n"+"Flight_Id:"+flight_Id+"\n"+"Booked_Tickets"+booked_seats+"\n"+"Price_booked"+price_booked;
    }
}
