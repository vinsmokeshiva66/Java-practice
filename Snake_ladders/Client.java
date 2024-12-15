import java.util.*;

public class Client {
    public static void main(String[] args) {
        Player p1=new Player("Shiva");
        Player p2=new Player("Saru");
        Dice d1=new Dice(1);
        Snake s1=new Snake(10,2);
        Snake s2=new Snake(99,12);
        Ladder l1=new Ladder(5,25);
        Ladder l2=new Ladder(40,89);
        List<Snake> snakes=new ArrayList<>();
        snakes.add(s1);
        snakes.add(s2);
        List<Ladder> ladders=new ArrayList<>();
        ladders.add(l1);
        ladders.add(l2);
        Board newboard=new Board(snakes, ladders, 100);
        Queue<Player>players=new LinkedList<>();
        players.offer(p1);
        players.offer(p2);
        Game game=new Game(players,d1,newboard);
        game.startGame();

    }
}
