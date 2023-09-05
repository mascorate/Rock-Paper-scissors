import java.util.Random;

public class Computer extends Player {

    private Random rand;
    private final int MAX_NUMBER = 3;

    public Computer() {
        setName("Computer");
        this.hp = 100;
        rand = new Random();
    }

    public void selectChoice() {
        int randomNumber = rand.nextInt(MAX_NUMBER)+1;
        switch(randomNumber) {
            case 1:
                setChoice("ROCK");
                break;
            case 2:
                setChoice("PAPER");
                break;
            case 3:
                setChoice("SCISSORS");
                break;
        }
    }
}