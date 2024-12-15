import java.util.*;

public class Hotel {
    private List<Room>rooms=new ArrayList<>();
    private Map<String,Guest>guests=new HashMap<>();
    private Guest guest;

    public String addRoom(String roomtype,double price){
        Room newroom=new Room(roomtype, price);
        rooms.add(newroom);
        return "Room added successfully";
    }

    public String registerGuest(String name){
        Guest newguest=new Guest(name);
        guests.put(newguest.getguestId(),newguest);
        return "Guest added successfully";
    }

    public boolean bookRoom(String guestId,String roomNumber,int night){
        for(Room i:rooms){
            if(i.getRoomDetails().contains(roomNumber)){
                guest.bookRoom(i, night);
                i.bookRoom();
                System.out.print("Room has been booked");
                return true;
            }
        }
        System.out.println("Room not available");
        return false;
    }

    public boolean releaseRoom(String roomNumber){
        for(Room i:rooms){
            if(i.getRoomDetails().contains(roomNumber) && i.getRoomDetails().contains("false")){
                i.releaseRoom();
                System.out.print("Room has been vacated");
                return true;
            }
        }
        System.out.print("Room not occupied");
        return false;
    }

    public String getRoomDetails(String roomnumber){
        for(Room i:rooms){
            if(i.getRoomDetails().contains(roomnumber)){
                return i.getRoomDetails();
            }
        }
        return "";
    }

    public String getGuestBookingDetails(String guestId){
        return guests.get(guestId).toString();
    }

}
