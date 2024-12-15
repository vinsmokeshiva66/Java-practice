public class Parking_spot {
    private int spotId;
    private Spot_size size;
    private boolean isavailable;
    private Vehicle curr_vehicle;

    Parking_spot(int spotId,Spot_size size,boolean isavailable){
        this.spotId=spotId;
        this.size=size;
        this.isavailable=true;
    }

    public boolean isAvailable(){
        return isavailable;
    }

    public Spot_size getsize(){
        return size;
    }

    public void parkVehiclee(Vehicle curr_vehicle){
        this.curr_vehicle=curr_vehicle;
        this.isavailable=false;
    }

    public void releaseSpot(int spotId){
        this.isavailable=true;
        this.curr_vehicle=null;
    }

    public Vehicle getCurrentVehicle(){
        return curr_vehicle;
    }

    public int getspotId(){
        return spotId;
    }

}
