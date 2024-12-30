import java.util.Scanner;

public class Tictactoemain {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        boolean runner=true;
        while(runner){
            System.out.println("Please register the two players.");
            System.out.println("Enter player1 name:");
            String name1=sc.nextLine();
            System.out.println("Enter player1 character Preference:");
            Character ch1=sc.next().charAt(0);
            sc.nextLine();
            Players p1=new Players(name1,ch1);
            System.out.println("Enter player2 name:");
            String name2=sc.nextLine();
            System.out.println("Enter player2 character Preference:");
            Character ch2=sc.next().charAt(0);
            if(ch1=='X' && ch2=='X'){
                System.out.println("X has already been taken by player 1 please use O");
                ch2='O';
            }else if(ch1=='O' && ch2=='O'){
                System.out.println("O has already been taken by player 1 please use X");
                ch2='X';
            }
            Players p2=new Players(name2, ch2);
            Play play=new Play();
            play.addPlayers(p1);
            play.addPlayers(p2);
            play.startgame();
            sc.close();
            runner=false;
        }
    }
}
