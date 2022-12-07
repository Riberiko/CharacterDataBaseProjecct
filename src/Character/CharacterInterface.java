package Character;

public interface CharacterInterface {

    /**
     * heals the character
     * @param val point to add
     */
    public void heal(int val);

    /**
     * injures the character
     * @param val to remove
     */
    public void injure(int val);

    /**
     * changes the characters moralality
     * @param percent   to change the morality to
     */
    public void change(double percent);

}
