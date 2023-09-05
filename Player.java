
public  class Player
{
    private String name;
    private String choice;
    public int hp ;
    public int mp ;
    public String skill;

    public Player() {
        
    }
    
    public Player(String name) {
        this.name = name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String getName() {
        return name;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String newChoice) {
        choice = newChoice;
    }
    
    public  void selectChoice(String selectChoice){
        this.choice = selectChoice;
    }
    
    public String getSkill() {
        return skill;
    }
    
    public void setSkill(String newSkill){
       skill = newSkill; 
    }
    
    public void selectSkill(String selectSkill){
        this.skill = selectSkill;
    }
}

