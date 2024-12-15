import java.util.UUID;

public class Room {
    private String roomNumber;
    private String roomType;
    private double price;
    private boolean isavailable;

    public Room(String roomType,double price){
        this.roomNumber=UUID.randomUUID().toString();
        this.price=0.00;
    }

    public String getRoomDetails(){
        return "RoomDetails{" +
        "roomNumber='" + roomNumber + '\'' +
        ", roomType='" + roomType + '\'' +
        ", price=" + price +
        ", isavailable=" + isavailable +
        '}';
    }

    public void bookRoom(){
        this.isavailable=false;
    }

    public void releaseRoom(){
        this.isavailable=true;
    }
}
