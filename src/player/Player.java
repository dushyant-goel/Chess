package player;
import person.Person;

public class Player {
    
    private Person person;
    private boolean whiteSide = false;
    
    public Player(Person person, boolean whiteSide) {
        this.person = person;
        this.whiteSide = whiteSide;
    }

    public boolean isWhiteSide() {
        return this.whiteSide == true;
    }
    
    public Person getPerson() {
        return person;
    }
}
