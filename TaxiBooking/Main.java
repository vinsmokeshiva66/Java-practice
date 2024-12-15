import java.util.Scanner;

public class Main {
     public static void main(String[] args)throws CloneNotSupportedException{ 
        boolean loop=true;

        while(loop){

            System.out.println("Choose any one\n1.Book Taxi\n2.Display Details\n3.Exit");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();

            switch(n){
                case 1:
                    System.out.println("Enter PickUp Location:");
                    char pickuplocation=sc.next().charAt(0);
                    System.out.println("Enter Drop Location:");
                    char droplocation=sc.next().charAt(0);
                    System.out.println("Enter pickup time");
                    int pickuptime=sc.nextInt();
                    System.out.println(TaxiBooking.booking(pickuplocation, droplocation, pickuptime));
                    break;
                case 2:
                    TaxiBooking.display();
                    break;
                case 3:
                    loop=false;
                    System.out.println("\tThank You!!!");
				    sc.close();
				    break;
            }
        }
    }
}
