package CharacterDataBase;

import Character.Character;

import HashMap.HashedDictionary;

public interface CharacterDataBaseInterface {

    public int addCharacter(String name, int height, int wight, double moralAlign);

    public void removeCharacter(String name);

    public Character getCharacter(String name);

    public HashedDictionary<String, Integer> getHashTable();
}
