public class Vehicle {
    private String vehicleNumber;
    private Vehicle_Type type;

    Vehicle(String vehicleNumber,Vehicle_Type type){
        this.vehicleNumber=vehicleNumber;
        this.type=type;
    }

    public String getvehicleNumber(){
        return vehicleNumber;
    }

    public Vehicle_Type getType(){
        return type;
    }
}
