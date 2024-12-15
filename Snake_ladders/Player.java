public class Player {
    private int steps=0;
    private String name;

    Player(String name){
        this.name=name;
    }

    public int getPosition(Player player){
        return steps;
    }

    public String getName(Player player){
        return name;
    }

    public void setPosition(int steps){
        this.steps=steps;
    }
}
