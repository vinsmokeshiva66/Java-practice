import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Reservation_system r1=new Reservation_system();
        Flight f1=new Flight(1);
        Flight f2=new Flight(2);
        Flight f3=new Flight(3);

        boolean loop=true;
        while(loop){
            System.out.println("Choose any one\n1.Book Flight\n2.Cancel Flight\n3.Display details\n4.Exit");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Enter flight ID:");
                    int flight_Id=sc.nextInt();
                    System.out.println("Enter total seats:");
                    int total_seats=sc.nextInt();
                    r1.book(flight_Id,total_seats);
                    break;
                case 2:
                    System.out.println("Enter your passenger Id:");
                    int passenger_Id=sc.nextInt();
                    System.out.println("Enter your flight Id:");
                    int flight_Id1=sc.nextInt();
                    r1.cancel(passenger_Id,flight_Id1);
                    break;
                case 3:
                    r1.Ticketdetails();
                    break;
                case 4:
                    loop=false;
                    System.out.println("Thank you");
                    sc.close();
                    break;
            }
        }
    }
}
