public class Ladder {
    private int bottom;
    private int top;

    Ladder(int bottom,int top){
        this.bottom=bottom;
        this.top=top;
    }

    int getTopPosition(Ladder ladder){
        return top;
    }

    int getBottomPosition(Ladder ladder){
        return bottom;
    }
}
