import java.util.*;

public class Game {
    private Queue<Player> players;
    private Dice dice;
    private Board board;

    Game(Queue<Player> players,Dice dice,Board newBoard){
        this.players=players;
        this.dice=dice;
        this.board=newBoard;
    
    }
    public void startGame(){
    while(true){
        Player newplayer=players.poll();
        int curr_pos=newplayer.getPosition(newplayer);
        if(curr_pos==100){
            System.out.println("The Winner is" + newplayer.getName(newplayer));
            return;
        }
        int dice_val=dice.rollDice();
        int check=board.getNewPosition(dice_val);
        if(check==0){
            curr_pos+=dice_val;
            if(curr_pos==100){
                System.out.println("The winner is"+" "+newplayer.getName(newplayer));
                return;
            }else if(curr_pos>100){
                curr_pos=0;
            }
        }else if(check>100){
            curr_pos=0;
        }else if(check==100){
            System.out.println("The winner is"+" "+ newplayer.getName(newplayer));
            return;
        }
        newplayer.setPosition(curr_pos);
        System.out.println(newplayer.getName(newplayer)+" "+"has been moved to"+" "+newplayer.getPosition(newplayer));
        players.add(newplayer);
    }}
}
