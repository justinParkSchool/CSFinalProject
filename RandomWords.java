package finalproject;

import java.util.ArrayList;

public class RandomWords {

    //Values for making random words - Written by Hajin, modified by Justin
    private String[] words = {"hello", "world", "computer", "science", "constructor", "integer", "double", "float", "byte", "long", "char", "boolean", "short", "string", "array", "class", "return", "interface", "package", "scanner", "compiler", "variable", "override"}; // word bank
    private ArrayList<String> wordsOffScreen = new ArrayList<>();

    private String word;

    //Puts words in String[] to an ArrayList for ease of access, used in GenerateLabel - Written by Justin
    public void makeArrayList() {
        for (int i = 0; i < words.length; i++) {
            wordsOffScreen.add(words[i]);
        }
    }
    
    public void addCurrentWord(String str) {
        wordsOffScreen.add(str);
    }

    //Generates random number that will be the index of the words ArrayList - Written by Hajin, modified by Justin
    public int generateRandomNumber() {
        int max = wordsOffScreen.size() - 1;
        int min = 0;
        int random = (int) (Math.random() * (max - min + 1) + min);
        return random;
    }

    /**
     * Gets the random words from the words ArrayList based on random number
     * generated, then removes that words from the ArrayList, used in GameFrame
     * and GenerateLabel - Written by Hajin, modified by Justin
     */
    public String getRandomWords() {
        if (wordsOffScreen.size() != 0) {
                int randomNumber = generateRandomNumber();
                word = wordsOffScreen.get(randomNumber);
                wordsOffScreen.remove(randomNumber);
                System.out.println(wordsOffScreen);
                return word;
            } else {
                return "goodbye";
            }
    }

    public void resetRandomWords() {
        wordsOffScreen = new ArrayList<>();
        word = "";
    }
}
