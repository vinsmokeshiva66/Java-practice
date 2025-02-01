public class Flight {
    int flight_Id;
    int total_seats=50;
    int price=5000;

    public Flight(int flight_Id){
        this.flight_Id=flight_Id;
        Reservation_system.total_flights.add(this);
    }

    public int getTotal_seats(){
        return total_seats;
    }

    public int getFlight_id(){
        return flight_Id;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int new_price){
        this.price=new_price;
    }
}
