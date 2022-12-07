package Testing;

import org.junit.jupiter.api.*;

import HashMap.HashedDictionary;

public class DictionaryTest extends Assertions{

    HashedDictionary<String, Integer> dic;

    static String remove = "Dictionary Remove Method Failed";
    static String add = "Dictionary Add Method Failed";
    static String search = "Dictionary Search Method Failed";

    @BeforeEach
    void setUp(){
        dic = new HashedDictionary<>();
    }

    @Test
    public void testAdd(){

        dic.add("a", 2);
        dic.add("c", 3);
        dic.add("b", 4);
        dic.add("d", 5);

        assertEquals(2,dic.add("a",5), add);
        assertEquals(null, dic.add("Riko", 20), add);

    }

    @Test
    public void TestRemove(){

        dic.add("a", 2);
        dic.add("c", 3);
        dic.add("", 4);
        dic.add("d", 5);

        assertEquals(2, dic.remove("a"), remove);
        assertEquals(null, dic.remove("a"), remove);
        assertEquals(null, dic.remove("Y"), remove);
        assertEquals(5, dic.remove("d"), remove);


    }

    @Test
    public void testSearch(){

        dic.add("a", 2);
        dic.add("c", 3);
        dic.add("b", 4);
        dic.add("d", 5);
        dic.add("Siblings", 10);
        dic.add("Teheran", 15);

        assertEquals(2, dic.getValue("a"), search);

        dic.add("a", 5);

        assertEquals(5, dic.getValue("a"), search);
        assertNotEquals(15, dic.getValue("Siblings"));

    }

}
