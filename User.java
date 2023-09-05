import java.util.Scanner;

public class User extends Player
{
    private Scanner input;

    public User() {
        input = new Scanner(System.in);
        this.hp = 50;
        this.mp = 0;
    }
    
    public void selectSkill() {
        System.out.println("Enter your Skill : 1 - User , 2 - Don't use");
        setSkill(input.nextLine());
    }

    public void selectChoice() {
        System.out.println("Enter your choice: R - Rock, P - Paper, S - Scissors");
        setChoice(input.nextLine().toUpperCase());
    }
}

