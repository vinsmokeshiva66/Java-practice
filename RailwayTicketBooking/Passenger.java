public class Passenger {
    private String name;
    private int age;
    private String gender;
    private int tickedId;

    Passenger(String name,int age,String gender,int tickedId){
        this.age=age;
        this.name=name;
        this.gender=gender;
        this.tickedId=tickedId;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public int getTickerid(){
        return tickedId;
    }

    public String Passengerdetails(){
        return "Name :" + name + "Age" + age +"Gender" + gender +"Ticker_ID" + tickedId;
    }
}
