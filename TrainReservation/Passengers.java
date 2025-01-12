public class Passengers {
    private String name;
    private int age;
    private String gender;
    private String berth_preference;
    private int pnr;
    private String seat_number;
    private boolean children;

    Passengers(String name,int age,String gender,String berth_preference,boolean children){
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.berth_preference=berth_preference;
        this.children=children;
    }

    public String getBerth_preference(){
        return berth_preference;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }

    public void setPnr(int pnr){
        this.pnr=pnr;
    }

    public void setSeat_number(String seat_number){
        this.seat_number=seat_number;
    }

    public boolean isChildren(){
        return children;
    }

    public int getPnr(){
        return pnr;
    }

    public String getSeat_number(){
        return seat_number;
    }

    public String getName(){
        return name;
    }

    public String getPassngerdetails(){
        return "Name:\n"+ name + "PNR number:\n"+pnr + "Seat number:\n"+seat_number;
    }
}
