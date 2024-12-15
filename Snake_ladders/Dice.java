public class Dice {
    private int numberofDice;

    Dice(int numberofDice){
        this.numberofDice=numberofDice;
    }

    int rollDice(){
        return (int)(Math.random() * (6 * numberofDice - numberofDice + 1)) + numberofDice;
    }
}
