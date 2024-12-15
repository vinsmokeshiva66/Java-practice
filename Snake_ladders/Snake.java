public class Snake {
    private int head;
    private int tail;

    Snake(int head,int tail){
        this.head=head;
        this.tail=tail;
    }

    int getTailPosition(Snake snake){
        return tail;
    }

    int getHeadPosition(Snake snake){
        return head;
    }
}
