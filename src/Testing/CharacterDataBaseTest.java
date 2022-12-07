package Testing;

import org.junit.jupiter.api.*;

import CharacterDataBase.CharacterDatabase;

public class CharacterDataBaseTest extends Assertions{

    CharacterDatabase database;

    @BeforeEach
    void setUp(){
        database = new CharacterDatabase();

        database.addCharacter("Riko", 62, 200, 0);
        database.addCharacter("Athanase", 60, 175, -1);
        database.addCharacter("Cesariya", 64, 210, 1);
    }

    @Test
    public void testAdd(){
        database.addCharacter("Innocent", 62, 155, -0.5);

        assertEquals("Riko 0\nAthanase 1\nCesariya 2\nInnocent 3\n", database.dictionaryString());
        assertEquals("[ID : 0\nUserName : Riko\nCharacterType : WARRIOR\nHealth : 0," +
                " ID : 1\nUserName : Athanase\nCharacterType : WARRIOR\nHealth : 0," +
                " ID : 2\nUserName : Cesariya\nCharacterType : WARRIOR\nHealth : 0," +
                " ID : 3\nUserName : Innocent\nCharacterType : WARRIOR\nHealth : 0]"
                , database.toString());
    }

    @Test
    public void restRemove(){
        database.removeCharacter("Riko");   // exsiting user

        assertEquals("available - removed state\nAthanase 1\nCesariya 2\n", database.dictionaryString());
        assertEquals("[null," +
                " ID : 1\nUserName : Athanase\nCharacterType : WARRIOR\nHealth : 0," +
                " ID : 2\nUserName : Cesariya\nCharacterType : WARRIOR\nHealth : 0]"
                , database.toString());

        database.removeCharacter("Ribeiko");    //non exsiting user

        assertEquals("available - removed state\nAthanase 1\nCesariya 2\n", database.dictionaryString());
        assertEquals("[null," +
                        " ID : 1\nUserName : Athanase\nCharacterType : WARRIOR\nHealth : 0," +
                        " ID : 2\nUserName : Cesariya\nCharacterType : WARRIOR\nHealth : 0]"
                , database.toString());

        database.removeCharacter("Cesariya");   //exisiting user

        assertEquals("available - removed state\nAthanase 1\navailable - removed state\n", database.dictionaryString());
        assertEquals("[null," +
                        " ID : 1\nUserName : Athanase\nCharacterType : WARRIOR\nHealth : 0," +
                        " null]"
                , database.toString());

    }

    @Test
    public void testSearch(){
        assertEquals("ID : 1\nUserName : Athanase\nCharacterType : WARRIOR\nHealth : 0",
                database.getCharacter("Athanase").toString());  //testing existing user

        assertEquals(null, database.getCharacter("Riberiko"));  //testing non existing user
    }
}
