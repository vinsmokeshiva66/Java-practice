import java.util.*;

public class Reservationsystem {
    static int pnr_number=1001;
    static int total_seats=63;
    static int rac=18;
    static int waitinglist=10;

    static int upper_seat=1;
    static int middle_seat=2;
    static int lower_seat=3;

    int seats[]=new int[3];
    //0 upper    1 middle   2 lower

    List<Passengers>booked_seats=new ArrayList<>();
    Queue<Passengers>rac_seats=new LinkedList<>();
    Queue<Passengers>waiting_list=new LinkedList<>();

    Queue<String>cancelled_seats=new LinkedList<>(); // stores cancelled seat numbers


    public void book(Passengers p){
        if(p.getAge()<5){
            System.out.println("Ticket won't be allocated for children's");
            return;
        }

        if(p.getAge()>5){
            Character confirmed=checkConfirmed(p.getBerth_preference(),p.getAge(),p.getGender(),p.isChildren());
            if(confirmed=='L'){
                total_seats--;
                p.setPnr(pnr_number++);
                p.setSeat_number("L"+lower_seat);
                lower_seat+=3;
                seats[2]++;
                booked_seats.add(p);
                System.out.println("Booked successfully PNR is:"+p.getPnr());
                return;
            }else if(confirmed=='M'){
                total_seats--;
                p.setPnr(pnr_number++);
                p.setSeat_number("M"+middle_seat);
                middle_seat+=3;
                seats[1]++;
                booked_seats.add(p);
                System.out.println("Booked successfully PNR is:"+p.getPnr());
                return;
            }else if(confirmed=='U'){
                total_seats--;
                p.setPnr(pnr_number++);
                p.setSeat_number("U"+upper_seat);
                upper_seat+=3;
                seats[0]++;
                booked_seats.add(p);
                System.out.println("Booked successfully PNR is:"+p.getPnr());
                return;
            }
            if(confirmed=='F' && rac>0){
                rac_seats.add(p);
                rac--;
                System.out.println("Added to RAC list");
                return;
            }else if(confirmed=='F' && waitinglist>0){
                waiting_list.add(p);
                waitinglist--;
                System.out.println("Added to waiting list");
                return;
            }
        }
        System.out.println("All ticket have been sold out");
    }

    public void cancel(int pnr){
        for(Passengers passenger : booked_seats){
            if(pnr==passenger.getPnr()){
                booked_seats.remove(pnr);
                total_seats++;
                checkcancelledseat(passenger); // check for L,M,U and increment respective seats
                System.out.println("Ticket has been cancelled successfully");
            }
        }
        checkracallocation();
    }

    public Character checkConfirmed(String berth,int age,String gender,boolean children){
        if(age>60 || gender.equals("female") && children){
            if(seats[2]<21) return 'L';
        }
        if(berth.equals("upper") && seats[0]<21) return 'U';
        if(berth.equals("middle") && seats[1]<21) return 'M';

        if(seats[0]==21 && seats[1]<21) return 'M';
        if(seats[1]==21 && seats[0]<21) return 'U';

        return 'F';
    }

    public void checkcancelledseat(Passengers p){
        String cancelledseat=p.getBerth_preference();
        if(cancelledseat.equals("upper")){
            cancelled_seats.add(p.getSeat_number());
        }else if(cancelledseat.equals("middle")){
            cancelled_seats.add(p.getSeat_number());
        }else if(cancelledseat.equals("lower")){
            cancelled_seats.add(p.getSeat_number());
        }
    }

    public void checkracallocation(){
        while(cancelled_seats.size()!=0 && rac_seats.size()!=0 && total_seats>0){
            for(String seats:cancelled_seats){
                Passengers racp=rac_seats.poll(); // gets RAC passenger
                racp.setSeat_number(seats);
                rac++;
                booked_seats.add(racp);
                total_seats++;
                cancelled_seats.remove(seats);
            }
        }
    }

    public void checkwaitinglistallocation(){
        while(rac>0 && waiting_list.size()!=0){
            rac_seats.offer(waiting_list.poll());
            rac--;
            waitinglist++;
        }
    }

    public void Bookedtickets(){
        for(Passengers passenger:booked_seats){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(passenger.getPassngerdetails());
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        System.out.println("Total seats booked:"+total_seats);
    }

    public void remainingtickets(){
        System.out.println("----------------------------------------------");
        System.out.println("Available upper berth:"+seats[0]);
        System.out.println("Available middle berth:"+seats[1]);
        System.out.println("Available lower berth:"+seats[2]);
        System.out.println("----------------------------------------------");
    }
}
