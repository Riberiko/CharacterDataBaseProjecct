package Testing;

import org.junit.jupiter.api.*;
import Character.Character;
import Character.CharacterType;

public class CharacterTest extends Assertions {

    static Character[] chars;

    @BeforeAll
    static void setUp(){
        chars = new Character[4];
    }

    @BeforeEach
    void newSetUp(){
        chars[0] = new Character("Riko");
        chars[1] = new Character("Eric");
        chars[2] = new Character("David");
        chars[3] = new Character("Sam");
    }

    @Test
    void testConstructor(){

        assertEquals("Riko", chars[0].getName());
        assertEquals("Eric", chars[1].getName());
        assertEquals("David", chars[2].getName());
        assertEquals("Sam", chars[3].getName());
    }

    @Test
    void testGetters(){
        assertEquals(CharacterType.WARRIOR, chars[0].getType());
    }

    @Test
    void testSetters(){
        chars[1].setCharacterType(CharacterType.MAGE);
        assertEquals(CharacterType.MAGE, chars[1].getType());
    }
}
