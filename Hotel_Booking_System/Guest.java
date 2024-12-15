import java.util.*;

public class Guest {
    private String guestId;
    private String name;
    private Room bookedRoom;
    private int numberOfNights;

    public Guest(String name){
        this.name=name;
        this.guestId=UUID.randomUUID().toString();
    }

    public void bookRoom(Room room,int nights){
        this.bookedRoom=room;
        this.numberOfNights=nights;
    }


    public String getBookingDetails(){
        return "GuestDetails{" +
        "GuestId='" + guestId + '\'' +
        ", name='" + name + '\'' +
        ", bookedRoom=" + bookedRoom.getRoomDetails() +
        ", Nights=" + numberOfNights +
        '}';
    }

    public String getguestId(){
        return guestId;
    }

}
