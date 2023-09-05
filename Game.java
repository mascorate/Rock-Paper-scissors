import java.util.Scanner;
import java.util.Random;

public class Game {
    private User p;
    private Computer com;
    //private int playerWins;
    //private int playerLoses;
    //private int ties;
    private boolean isRunning = false;
    private Scanner scan;
    private Random rand;
    private final int MAX_NUMBER = 3;

    public Game() {
        p = new User();
        com = new Computer();
        scan = new Scanner(System.in);
        rand = new Random();
        clear();
        start();
        
    }

    private void start() {
        isRunning = true;
        System.out.println("Please, enter your name:");
        p.setName(scan.nextLine());
        clear();
        while(isRunning) {
            displayScore();
            p.selectSkill();
            displaySkill(useSkill());
            p.selectChoice();
            com.selectChoice();
            clear();
            displayChoices();
            displayWinner(decideWinner());
            //updateScore(decideWinner());
            updateStatus(decideWinner());
            Die();
        }
    }
    

    private void displayScore() {
        System.out.println(p.getName());
        System.out.println("----------");
        System.out.println("Player HP: " + p.hp);
        System.out.println("Player MP: " + p. mp);
        System.out.println("Auto-Bot HP: " + com.hp);
        System.out.println("----------");
    }

    
    private int useSkill() {
        if(p.getSkill().equals("1"))
            return 0;
        else
            return 1;
    }
    
    public void randomSkill() {
        int randomNumber = rand.nextInt(MAX_NUMBER)+1;
        switch(randomNumber) {
            case 1:
                com.hp = com.hp - 20;
                System.out.println("Your Random 20 Damge Skill\nCurrentHP AutoBot"+com.hp+"\n");
                break;
            case 2:
                p.hp = p.hp + 20;
                System.out.println("You Random 20 heal Skill\nCurrentHP"+p.hp+"\n");
                break;
            case 3:
                p.hp = p.hp - 10;
                System.out.println("You hp -10 Damge\nCurrentHP"+p.hp+"\n");
                break;
        }
    }
    
    private void displaySkill(int skill) {
        switch(skill) {
            case 0:
                p.mp = p.mp - 2;
                if(p.mp < 0 ){
                    p.mp = p.mp + 2;
                    System.out.println("not enough mana\n");
                    break;
                }
                else{
                    randomSkill();
                }
                break;
            case 1:
                System.out.println("Don't Use Skill\n");
                break;
        }
    }
    
    private int decideWinner() {
        // 0 - User wins
        // 1 - Computer wins
        // 2 - tie
        
        if(p.getChoice().equals("R") && com.getChoice().equals("SCISSORS"))   
            return 0 ;     
        else if(p.getChoice().equals("P") && com.getChoice().equals("ROCK"))
            return 0 ;       
        else if(p.getChoice().equals("S") && com.getChoice().equals("PAPER"))
            return 0 ;     
        else if(com.getChoice().equals("ROCK") && p.getChoice().equals("S"))
            return 1 ;
        else if(com.getChoice().equals("PAPER") && p.getChoice().equals("R"))
            return 1 ;
        else if(com.getChoice().equals("SCISSORS") && p.getChoice().equals("P"))  
            return 1 ;
        else
            return 2 ;
        
    }

    private void displayChoices() {
        System.out.println("User has selected: " + p.getChoice());
        System.out.println("Computer has selected: " + com.getChoice());
    }

    private void displayWinner(int winner) {
        switch(winner) {
            case 0:
                System.out.println("Player Attack\n");
                break;
            case 1:
                System.out.println("Auto-Bot Attack\n");
                break;
           case 2:
                System.out.println("it's a Tie\n");
       }
    }

    private void Die() {
        if( p.hp <= 0 ){
            System.out.println("You lose");
            isRunning = false;
        }
        
        else if( com.hp <= 0 ){
            System.out.println("You Win");
            isRunning = false;
        }
    }

    
    private void updateStatus(int winner) {
        p.mp = p.mp +1;
        if(winner == 0 ){
            com.hp = com.hp - 10; 
        }
        else if(winner ==1 ){
            p.hp = p.hp - 10;
        }
        else if(winner == 2){
            p.hp = p.hp - 0; 
        }
            
    }
    
    private static void clear(){
        for(int i=0; i < 50; i++){
            System.out.println("");
        }
    }
    

}