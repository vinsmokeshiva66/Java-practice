import java.util.*;

public class Ticket {
    private String ticketId;
    private Date startTime;
    private int spotId;

    public Ticket(int spotId){
        this.ticketId=UUID.randomUUID().toString();
        this.startTime=new Date();
        this.spotId=spotId;
    }

    public double calculateCharges(){
        Date endTime=new Date();
        long duration = (endTime.getTime() - startTime.getTime()) / (1000 * 60 * 60);
        duration=Math.max(duration,1);
        return 5+(duration-1)*3;
    }
     public String getTicketId(){
        return ticketId;
     }

     public int getSpotId(){
        return spotId;
     }
}
