public class Main {

    public static void main(String[] args){
        CharacterCounter myCharacterCounter = new CharacterCounter();
        //String myUsersInput = myCharacterCounter.getUserInput();
        String myUsersInput = myCharacterCounter.getTextFromFile("example.txt");
        myCharacterCounter.countCharacters(myUsersInput);
    }
}
