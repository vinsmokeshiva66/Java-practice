import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        boolean loop=true;

        while(loop){
            System.out.println("Choose any one\n1.Book Ticket\n2.Cancel a ticket\n3.View booked tickets\n4.View remaining tickets\n5.Exit");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();
            Reservationsystem reserve=new Reservationsystem();
            switch (n) {
                case 1:
                    System.out.println("Enter you name:");
                    String name=sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter your age:");
                    int age=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter your gender");
                    String gender=sc.nextLine();
                    System.out.println("Enter Berth preference:");
                    String berth=sc.nextLine();
                    System.out.println("Is children below 5 is there");
                    String children=sc.nextLine();
                    boolean c=false;
                    if(children.equals("yes")) c=true;
                    Passengers p=new Passengers(name, age, gender,berth,c);
                    reserve.book(p);
                    break;
                
                case 2:
                    System.out.println("Enter you PNR number");
                    int pnr=sc.nextInt();
                    reserve.cancel(pnr);
                    break;
                case 3:
                    reserve.Bookedtickets();
                    break;
                case 4:
                    reserve.remainingtickets();
                    break;
                case 5:
                    loop=false;
                    sc.close();
                    break;
                default:
                    break;
            }
        }
    }
}
