package CharacterDataBase;

import HashMap.HashedDictionary;
import Character.Character;

import java.util.ArrayList;

public class CharacterDatabase implements CharacterDataBaseInterface{

    private HashedDictionary<String, Integer> dictionary;
    private ArrayList<Character> characters;

    /**
     * Creates a database that will store characters
     */
    public CharacterDatabase(){
        dictionary = new HashedDictionary<>();
        characters = new ArrayList<Character>();
    }

    /**
     * Adds a character to the database
     * @param name  for the character
     * @param height    for the character
     * @param weight    for the character
     * @param moralAlignment    for the character
     * @return  a character if it updated a pre existing character
     */
    @Override
    public int addCharacter(String name, int height, int weight, double moralAlignment) {
        Integer temp = dictionary.add(name, characters.size());
        if(temp == null) characters.add(new Character(name, height, weight, moralAlignment));
        characters.get(characters.size()-1).setId(characters.size()-1);
        return characters.size()-1;
    }

    /**
     * Removes the character from the database using the username
     * @param name
     */
    @Override
    public void removeCharacter(String name) {
        Integer index = dictionary.remove(name);

        if(index != null) characters.set(index, null);  //sets to null so it does not mess with dictionary values
    }

    /**
     * retrieves a character using a key
     * @param name  the key
     * @return  the character if exists
     */
    @Override
    public Character getCharacter(String name) {

        Integer index = dictionary.getValue(name);  // grabs the index from the dictionary

        return (index == null) ? null : characters.get(index);  //only trys to grab the character if the dictionary has an associated index
    }

    /**
     *
     * @return  hashtable of all characters
     */
    @Override
    public HashedDictionary<String, Integer> getHashTable() {
        return dictionary;
    }

    /**
     * Prints out the dictionary complete string representation
     */
    public void print(){
        dictionary.displayHashTable();
    }

    /**
     *
     * @return  database string representation
     */
    public String toString(){
        return characters.toString();
    }

    /**
     *
     * @return  dictionary string representation
     */
    public String dictionaryString(){
        return dictionary.toString();
    }
}
