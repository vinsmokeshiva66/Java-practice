public class Players {
    private String name;
    private char character;

    Players(String name,Character ch){
        this.name=name;
        this.character=ch;
    }

    public Character getCharacter(){
        return character;
    }

    public String getName(){
        return name;
    }
}
