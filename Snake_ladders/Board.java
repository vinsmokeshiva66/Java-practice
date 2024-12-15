import java.util.*;

public class Board {
    private List<Snake> snakes;
    private List<Ladder> ladders;
    int boardSize;

    Board(List<Snake> snakes,List<Ladder> ladders,int boardSize){
        this.snakes=snakes;
        this.ladders=ladders;
        this.boardSize=boardSize;
    }

    public int getNewPosition(int currentPosition){
        for(Snake i:snakes){
            if(i.getHeadPosition(i)==currentPosition){
                System.out.println("Snake has bitten");
                return i.getTailPosition(i);
            }
        }
        for(Ladder j:ladders){
            if(j.getBottomPosition(j)==currentPosition){
                System.out.println("player has used ladder");
                return j.getTopPosition(j);
            }
        }
        return 0;
    }
}
