import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class CharacterCounter {
    //class variables
    //constructors
    public CharacterCounter() {
    }

    //methods
    public void countCharacters(String wordsToCount) {

        //make string case-insensitive
        wordsToCount = wordsToCount.toLowerCase();

        char[] arrayOfChars = wordsToCount.toCharArray();
        HashMap<Character, Integer> myCharacterCount = new HashMap<>();
        for (int i = 0; i < arrayOfChars.length; i++) {

            //exclude non-alphabetical characters
            if (Character.isLetter(arrayOfChars[i]) == false) {
                continue;
            }
            //add or updated the count of each character into the HashMap
            char theCharacter = arrayOfChars[i];
            if (myCharacterCount.containsKey(theCharacter) == false) {
                //does not contain the key
                myCharacterCount.put(theCharacter, 1);
            } else {
                //does contain the key
                Integer theValue = myCharacterCount.get(theCharacter);
                theValue = theValue + 1;
                myCharacterCount.put(theCharacter, theValue);
            }
        }
        ArrayList<Character> myCharacterKeys = new ArrayList<>(myCharacterCount.keySet());
        for (int i = 0; i < myCharacterKeys.size(); i++) {
            Integer theValue = myCharacterCount.get(myCharacterKeys.get(i));
            System.out.println(myCharacterKeys.get(i) + ": " + theValue);
        }
    }

    public String getUserInput() {
        Scanner myScanner = new Scanner(System.in);

        String myUsersInput = myScanner.nextLine();

        myScanner.close();

        return myUsersInput;
    }

    public String getTextFromFile(String pathToTheFile) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get(pathToTheFile)));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return content;
    }
}

