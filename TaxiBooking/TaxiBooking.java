import java.util.ArrayList;

public class TaxiBooking {
    private static ArrayList<Taxi> taxilist=new ArrayList<>();
    private static int taxilistlimit=4,idgenerator=1;
    private static ArrayList<Taxi> taxibookedhistory=new ArrayList<>();

    public static String booking(char pickuplocation,char droplocation,int pickuptime) throws CloneNotSupportedException{
        if(taxilist.size()<taxilistlimit){
            taxilist.add(new Taxi());
        }

        int min=Integer.MAX_VALUE;
        Taxi taxiready=null;

        for(Taxi t:taxilist){
            if(t.getdroptime()<=pickuptime && Math.abs(pickuplocation-t.getcurrentlocation())<=min){
                if(Math.abs(pickuptime-t.getcurrentlocation())==min){
                    if(taxiready!=null && t.getearnings()<=taxiready.getearnings()){
                        taxiready=t;
                    }
                }else{
                    taxiready=t;
                    min=Math.abs(pickuplocation=t.getcurrentlocation());
                }
            }
        }

        if(taxiready!=null){
            taxiready.setcustomerId(idgenerator++);
            taxiready.setpickuptime(pickuptime);
            taxiready.setpickuplocation(pickuplocation);
            taxiready.setcurrentlocation(droplocation);
            taxiready.setdroptime(pickuptime+(Math.abs(droplocation-pickuplocation)));
            taxiready.setearnings(taxiready.getearnings()+(Math.abs(droplocation-pickuplocation)*15-5)*10+100);
            taxiready.settaxiId(taxilist.indexOf(taxiready)+1);
            taxibookedhistory.add((Taxi)taxiready.clone());
        }

        return taxiready!=null?"Taxi Number "+taxiready.gettaxiId()+" is booked!":"Taxi not available";
    }

    public static void display(){
        System.out.println("-----------------");
        for(Taxi t:taxibookedhistory){
            System.out.println(t.toString());
            System.out.println("-----------------");
        }
    }
}
