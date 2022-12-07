package Character;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class Character implements CharacterInterface{

    private int health;
    private CharacterType type;
    private Integer id;

    private String name;    //Limit to 9 chars
    public int height;  //pixels
    private double weight; //kg

    private boolean onlineStatus;
    private double moralAlignment;

    public Character(String name){
        this(name, 64);
    }

    public Character(String name, int height){
        this(name, height, 10);
    }

    public Character(String name, int height, int weight){
        this(name, height, weight,0);
    }

    public Character(String name, int height, int weight, double moralAlignment){
        this(name, height, weight, moralAlignment, CharacterType.WARRIOR);
    }

    /**
     * Creates a Character
     * @param name  characters name
     * @param height    characters height
     * @param weight    characters weight
     * @param moralAlignment    characters moral alignment
     * @param type  characters type
     */
    public Character(String name, int height, int weight, double moralAlignment, CharacterType type){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.moralAlignment = moralAlignment;
        this.type = type;
    }

    public void logIn(){
        onlineStatus = true;
    }

    public void logOut(){
        onlineStatus = false;
    }

    /**
     * sets the name of the character
     * @param name  to set it to
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * sets the character type
     * @param type  to set the character type to
     */
    public void setCharacterType(CharacterType type){
        this.type = type;
    }

    /**
     * sets the characters health
     * @param health    to set the health to
     */
    public void setHealth(int health){
        this.health = health;
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void heal(int addHealth){
        assert addHealth <= 100;
        setHealth(health+addHealth);
    }

    /**
     * {{@inheritDoc}}
     */
    @Override
    public void injure(int removeHealth){
        assert removeHealth <= 100;
        setHealth(health-removeHealth);
    }

    /**
     *{{@inheritDoc}}
     */
    @Override
    public void change(double percent){
        assert percent <= 100 || percent >= -100;
        moralAlignment = (percent/100);
    }

    /**
     *
     * @return  the characters name
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return characters type
     */
    public CharacterType getType(){
        return type;
    }

    /**
     *
     * @return the characters health
     */
    public int getHealth(){
        return health;
    }

    /**
     * @return  the characters height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @return  the characters weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * sets the characters height
     * @param height to set the characters height to
     */
    public void setHeight(int height){
        this.height = height;
    }

    /**
     * sets the weight of the characher
     * @param weight    to set the weight to
     */
    public void setWeight(double weight){
        this.weight = weight;
    }

    /**
     * sets the id for the character
     * @param id    the desired id
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     *
     * @return  string representation of character
     */
    public String toString(){
        return "ID : " + id +"\nUserName : "+ name +"\nCharacterType : "+ type +"\nHealth : "+ health;
    }

}
