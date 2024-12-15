import java.util.Scanner;

public class Booking {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Reservationsystem r=new Reservationsystem();
        Train train1=new Train(1234,"A","D");
        Train train2=new Train(5678,"E","H");
        System.out.println(Reservationsystem.trains.size());
        Boolean loop=true;
        while(loop){

            System.out.println("Choose any one\n1.Book Train");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();

            switch(n){
                case 1:
                    System.out.println("Enter the Train_number :");
                    int train_number=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the total no of seats :");
                    int total_seats=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the berth preference :");
                    String berth=sc.nextLine();
                    System.out.println("Enter the passenger name:");
                    String name=sc.nextLine();
                    System.out.println("Enter the passenger age:");
                    int age=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the passenger gender:");
                    String gender=sc.nextLine();
                    Reservationsystem rs1=new Reservationsystem();
                    rs1.bookTicket(train_number, total_seats, berth, name, age, gender);
                    break;
                case 2:
                    Reservationsystem rs2=new Reservationsystem();
                    rs2.display_tickets(1234);
                    break;
                case 3:
                    loop=false;
                    System.out.println("Thank you");
                    sc.close();
                    break;
            }
        }
    }
}
