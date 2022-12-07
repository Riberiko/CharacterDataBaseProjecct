import Character.Character;
import CharacterDataBase.CharacterDatabase;

public class Main {
    public static void main(String[] args) {

        CharacterDatabase database = new CharacterDatabase();


        database.addCharacter("Siblings", 60,90,-1); //same hashcode
        database.addCharacter("Athanase", 20,90,-1);
        database.addCharacter("Riberiko", 64, 200, 0);
        database.addCharacter("Teheran", 80,90,0.5);  //same hashcode
        database.addCharacter("Frank", 60,90,0.5);
        database.addCharacter("Cesariya", 65, 210, 1);

        System.out.println("\tAdding to the dataBase || Creating new Users");

        database.print();

        System.out.println("\tExpected");

        System.out.println("null \n" +
                "null \n" +
                "null \n" +
                "Riberiko 2\n" +
                "Athanase 1\n" +
                "null \n" +
                "null \n" +
                "Teheran 3\n" +
                "null \n" +
                "Cesariya 5\n" +
                "null \n" +
                "Siblings 0\n" +
                "null \n" +
                "null \n" +
                "null \n" +
                "Frank 4\n" +
                "null \n" +
                "null \n" +
                "null \n" +
                "null \n" +
                "null \n" +
                "null \n" +
                "null");

        System.out.println("\tSearching for a user");

        System.out.println(database.getCharacter("Riberiko"));

        System.out.println("\tExpected");

        System.out.println("ID : 2\nUserName : Riberiko\nCharacterType : WARRIOR\nHealth : 0");

        System.out.println("\tRemoving User Riberiko");
        database.removeCharacter("Riberiko");
        System.out.println(database.getCharacter("Riberiko"));
        System.out.println("\tExpected when searching for removed character");
        System.out.println("null");
    }
}
