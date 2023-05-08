package finalproject;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;

public class GenerateLabel extends Thread {

    // Variabels for labels - Written by Justin
    private GameFrame gameFrame;
    private RandomWords randomWords;

    private int numOfLabels;
    private int counter = 0;

    private ArrayList<JLabel> labelArr = new ArrayList<>();
    private ArrayList<String> wordsOnScreen = new ArrayList<>();
    private ArrayList<Integer> position = new ArrayList<>();
    private ArrayList<Integer> column = new ArrayList<>();

    private int speed;
    private int speedIncreaseAmount;
    private int speedIncreaseNumRight;
    


   
    
   
    // Class constructor, connects GameFrame and RandomWords to GenerateLabel, adds
    // lables to ArrayList for ease of use, used in GameFrame - Written by Justin
    public GenerateLabel(GameFrame form, RandomWords Words) {
        gameFrame = form;
        randomWords = Words;
        numOfLabels = gameFrame.readVariables().get(0);
        speed = gameFrame.readVariables().get(1);
        startGenerateLabel();
    }

    // Creates the initial labels
    public void startGenerateLabel() {
        for (int i = 0; i < numOfLabels; i++) {
            labelArr.add(new JLabel("", JLabel.CENTER));
            labelArr.get(i).setFont(new Font("Monospaced", Font.BOLD, 15)); // TEMP
        }
        for (int i = 0; i < labelArr.size(); i++) {
            gameFrame.add(labelArr.get(i));
            position.add(0);
        }
        column.add(1);
        column.add(2);
        column.add(3);
        column.add(4);
        column.add(5);
        column.add(6);
        column.add(7);
        column.add(8);
        column.add(9);
        column.add(10);
    }

    // ACCESSOR METHOD
    public int getSpeed() {
        return speed;
    }

    public int getLabelArrSize() {
        return labelArr.size();
    }

    public void resetGenerateLabel() {
        column = new ArrayList<>();
        counter = 0;
        for (int i = 0; i < labelArr.size(); i++) {
            labelArr.get(i).setText("empty");
            gameFrame.remove(labelArr.get(i));
        }
        labelArr = new ArrayList<>();
        wordsOnScreen = new ArrayList<>();
        randomWords.resetRandomWords();
    }
    
        public void randomLocationLabel(int i) { // Randomizing label columns
        int max = (((1020 - 12 - 12*labelArr.size()) / (labelArr.size())) * (i + 1) + 12*(i)) - 100 +20;
        int min = ((1020 - 12 - 12*labelArr.size()) / (labelArr.size())) * i + 12*(i+1) +20;
        int random = (int) (Math.random() * (max - min + 1) + min);
        int randomY = (int) (Math.random() * (100 - 50 + 1) + 50);
        labelArr.get(i).setBounds(random, randomY, 100, 200);
        System.out.println(random);
    }

    // Adds the inital words, used in GameFrame - Written by Justin
    public void assignWords() {
        randomWords.makeArrayList();
        for (int i = 0; i < labelArr.size(); i++) {
            wordsOnScreen.add(randomWords.getRandomWords());
            labelArr.get(i).setText(wordsOnScreen.get(i));

        }
    }
    
    

    // Checks the user input, used in GameFrame - Written by Justin
    public boolean checkAnswer(String str) {
        if (wordsOnScreen.indexOf(str) != -1) {
            int currentLabel = wordsOnScreen.indexOf(str);
            System.out.println(currentLabel);
            randomWords.addCurrentWord(wordsOnScreen.get(currentLabel));

            String potentialNewWord = randomWords.getRandomWords();
            if (potentialNewWord.equals("goodbye") == false) {
                
                
              
              
                wordsOnScreen.set(currentLabel, potentialNewWord);
                labelArr.get(currentLabel).setText(wordsOnScreen.get(currentLabel));
                randomLocationLabel(currentLabel);
                gameFrame.addToWordsTypedRight(str);
                
            } else {
                wordsOnScreen.remove(currentLabel);
                labelArr.get(currentLabel).setText("");
                labelArr.remove(currentLabel);
            }
            return true;
        } else {
            return false;
        }
    }

    // Checks if all labels are empty, used in GameFrame - Written by Justin
    public boolean allEmptyLabels() {
        counter = 0;
        for (int i = 0; i < labelArr.size(); i++) {
            if (labelArr.get(i).getText() == "") {
                counter++;
            } else {
            }
        }
        if (counter == labelArr.size()) {
            return true;
        } else {
            return false;
        }
    }

    // Speeds up the label falling based on the words right - Written by Hajin
    public void speedUp() {
        speedIncreaseAmount = 5;
        speedIncreaseNumRight = 5;
        if (gameFrame.getNumRight() == speedIncreaseNumRight) {
            speed = speed + speedIncreaseAmount;
            gameFrame.resetNumRight();
        } else {
        }
    }

    public void run() {
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            return;
        }
        while (true) {
            for (int i = 0; i < labelArr.size(); i++) {
                labelArr.get(i).setLocation(labelArr.get(i).getX(), labelArr.get(i).getY() + 1);
                if (labelArr.get(i).getY() >= 500) {
                    
                    gameFrame.changeHealth();
                    new ColorThread(gameFrame).start();
                    randomWords.addCurrentWord(wordsOnScreen.get(i));
                    String potentialNewWord = randomWords.getRandomWords();
                    
                    if (potentialNewWord.equals("goodbye") == false) {
                        wordsOnScreen.set(i, potentialNewWord);
                        labelArr.get(i).setText(wordsOnScreen.get(i));
                        randomLocationLabel(i);
                    } else {
                        labelArr.remove(i);
                    }
                }
            }
            try {
                Thread.sleep(1000/speed);
            } catch (InterruptedException ex) {
                resetGenerateLabel();
                return;
            }
        }
    }
}

