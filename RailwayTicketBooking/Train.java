public class Train {
    private int Trainnumber;
    private String source;
    private String destination;
    private int Ac_seats=5;
    private int Sleeper_seats=5;

    Train(int Trainnumber,String source,String destination){
        this.Trainnumber=Trainnumber;
        this.source=source;
        this.destination=destination;
        Reservationsystem.trains.add(this);
    }

    public int getTrainnumber(){
        return Trainnumber;
    }

    public String getSource(){
        return source;
    }

    public String getDestination(){
        return destination;
    }

    public int getAcseats(){
        return Ac_seats;
    }

    public int getSleeperseats(){
        return Sleeper_seats;
    }

    public void setSleeperseats(int seats){
        this.Sleeper_seats-=seats;
    }

    public void setAcseats(int seats){
        this.Ac_seats-=seats;
    }

}
