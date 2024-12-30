import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Play {
    Queue<Players>player;
    static int total_moves=0;

    Play(){
        this.player=new LinkedList<>();
    }

    public void addPlayers(Players p){
        player.add(p);
    }
    
    Tictac t=new Tictac();
    Scanner sc=new Scanner(System.in);
    public void startgame(){
        while(total_moves<9){
            Players p1=player.poll();
            System.out.println(p1.getName()+" "+"Please choose the below");
            boolean valid=false;
            while(!valid){
                System.out.println("Choose anyone\n1.View the board\n2.Make a move\n3.exit");
                int num=sc.nextInt();
            switch (num) {
                case 1:
                    t.print_board();
                    break;
                case 2:
                    System.out.println("Enter row position:");
                    int row=sc.nextInt();
                    System.out.println("Enter column position");
                    int col=sc.nextInt();
                    if(row<0 || row>3 || col<0 || col>3){
                        System.out.println("Please enter the correct position!!!!");
                    }else if(t.tictac[row][col]=='_'){
                        t.tictac[row][col]=p1.getCharacter();
                        char winner =t.check(t.tictac);
                        if(winner=='X' || winner=='O'){
                            for(Players i:player){
                                if(i.getCharacter()=='X'){
                                    System.out.println("The winner is"+" "+i.getName());
                                    total_moves=10;
                                }else if(i.getCharacter()=='O'){
                                    System.out.println("The winner is"+" "+i.getName());
                                    total_moves=10;
                                }
                            }
                        }
                        total_moves++;
                        valid=true;
                        player.add(p1);
                    }else{
                        System.out.println("Please choose another position it's already been occupied");
                    }
                    break;
                default:
                    System.out.println("Thanks for playing!!");
                    sc.close();
                    break;
            }
        }     
    }
    System.out.println("Match has ended in a draw");
    }
}
