package finalproject;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameFrame extends javax.swing.JFrame {
    
    private RandomWords randomWords;
    private GenerateLabel generateLabel;
    private GameOver gameOver;
    private GameThread gameThread;
    
    private String answer;
    
    private ArrayList<String> wordsTypedRight = new ArrayList<>();
    private ArrayList<String> wordsTypedWrong = new ArrayList<>();  
    private ArrayList<String> records = new ArrayList<>();
    private ArrayList<Integer> recordsScore = new ArrayList<>();
    
    private ArrayList<Integer> variables = new ArrayList<>();
    private int score = 0;
    private int health = 100;
    private int takeAwayHealth;
    private int numRight;
    private int numWrong;
    private int newPlacementFrame;
    private boolean gameFrameStatus = false;

    /**
     * Creates new form GameFrame
     */
    public GameFrame() {
        initComponents();
        gameOver = new GameOver(this);
        resetGameFrame();
        System.out.println(this.getWidth());
        System.out.println(line.getY());
        
    }

    // For generating the initial labels - Written by Justin
    public void startGame() {
        takeAwayHealth = variables.get(2);
        healthBar.setValue(100);
        generateLabel.assignWords();
        for (int i = 0; i < generateLabel.getLabelArrSize(); i++) {
            generateLabel.randomLocationLabel(i);
        }
        generateLabel.start();
    }

    public void endGame() {
        readLeaderboardNames();
        readScores();
        newPlacementFrame = gameThread.checkScores();
        gameThread.interrupt();
        gameOver.setTimeLabel(stopwatchLabel.getText());
        gameOver.setScoreLabel(currentScoreLabel.getText());
        for (int i = 0; i < wordsTypedRight.size(); i++) {
            gameOver.setTextAreaTyped(wordsTypedRight.get(i));
        }
        gameOver.textAreaCursorUp();
        generateLabel.interrupt();
        resetGameFrame();
        Soundtrack.playEndmusic();
        Soundtrack.endMusicOn();
        TypingGame.gameOverVisible();
        gameOver.setVisible(true);
        gameThread.resetGameThread();
    }

    // ACCESSOR METHODS
    public GameThread getGameThread() {
        return gameThread;
    }
    
    public int getNewPlacement() {
        return newPlacementFrame;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getHealth() { 
        return health;
    }

    public int getNumRight() { // Used in GenerateLabel
        return numRight;
    }

    // MUTATOR METHODS
    public void addToWordsTypedRight(String str) {
        wordsTypedRight.add(str);
    }

    // For updating the stopwatch label, used in GameThread - Written by Paul
    public void updateStopwatch(String time) {
        stopwatchLabel.setText(time);
    }

    // For updating the health bar, used in GameThread- Written by Paul
    public void updateHealth() {
        healthBar.setValue(health);
    }

    // For updating the number of words typed, used in GameThread - Written by Paul;
    public int updateNumRight() {
        numRight = wordsTypedRight.size();
        return numRight;
    }

    public int updateNumWrong() {
        numWrong = wordsTypedWrong.size();
        return numWrong;
    }

    // for updating the score, used in GameThread - Written by Paul;
    public void updateScore(int numright) {
        score =  (numright * 100) - (numWrong * 10);
        currentScoreLabel.setText("Score: " + score);
    }

    // For writting the 3, 2, 1, Start when openning the GameFrame, used in
    // GameThread - Written by Justin
    public void updateStartCountdown(String str) {
        startCountdown.setText(str);
    }

    public int resetNumRight() {
        numRight = 0;
        return numRight;
    }
    
    public void resetGameFrame() {
        wordsTypedRight = new ArrayList<>();
        wordsTypedWrong = new ArrayList<>();
        gameFrameStatus = false;
        score = 0;
        health = 100;
        takeAwayHealth = 5;
        numRight = 0;
        numWrong = 0;
        userInput.setText("");
        healthBar.setForeground(Color.GREEN);
    }

    public void resetFileArrays() {
            records = new ArrayList<>();
            recordsScore = new ArrayList<>();
    }

    public void changeHealth() {
        health = health - takeAwayHealth;
    }


    public ArrayList<Integer> readVariables() {
        try {
            Scanner sc = new Scanner(new File("Settings.txt"));
            sc.nextLine();
            sc.nextLine();
            variables.add(Integer.parseInt(sc.nextLine()));
            variables.add(Integer.parseInt(sc.nextLine()));
            variables.add(Integer.parseInt(sc.nextLine()));
            return variables;
        } catch (FileNotFoundException e) {
            return new ArrayList<Integer>();
        }
    }

    public ArrayList<String> readLeaderboardNames() {
        try{
            Scanner sc = new Scanner(new File("LeaderboardNames.txt"));
            sc.nextLine();
            for(int i=0; i<10; i++) {
                records.add(sc.nextLine());
            }
            return records;
        } catch (FileNotFoundException e) {
            return new ArrayList<String>();
        }
    }

    public void setRecords(int index, String name) {
        records.add(index, name);
    }

    public String getRecords(int index) {
        return records.get(index);
    }

    public ArrayList<Integer> readScores() {
        try{
            Scanner sc = new Scanner(new File("Scores.txt"));
            sc.nextLine();
            for(int i = 0; i<10; i++) {
                recordsScore.add(Integer.parseInt(sc.nextLine()));
            }
            return recordsScore;
        } catch (FileNotFoundException e) {
            return new ArrayList<Integer>();
        }
    }

    public void setRecordsScore(int index, int score) {
        recordsScore.add(index, score);
    }

    public int getRecordsScore(int index) {
        return recordsScore.get(index);
    }
    
    public void changeColor (){
        if (healthBar.getValue()>80){
            healthBar.setForeground(Color.green);
        }
        else if (healthBar.getValue()>40){
            healthBar.setForeground(Color.yellow);
        }
        else {
            healthBar.setForeground(Color.red);
        }
    }
    
    public void changeLineColor() {
        line.setBackground(Color.red);
    }
    
    public void changeLineColorBack(){
        line.setBackground(Color.black);
    }
    
    public void userInputDisable() {
        userInput.setEnabled(false);
    }
    
    public void userInputEnable() {
        userInput.setEnabled(true);
    }
    public void changeUserInputRed(){
        userInput.setBackground(Color.red);
    }
    public void changeUserInputGreen(){
        userInput.setBackground(Color.green);
    }

    public void changeUserInputWhite(){
        userInput.setBackground(Color.white);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        healthBar = new javax.swing.JProgressBar();
        userInput = new javax.swing.JTextField();
        stopwatchLabel = new javax.swing.JLabel();
        currentScoreLabel = new javax.swing.JLabel();
        typeHereLabel = new javax.swing.JLabel();
        startCountdown = new javax.swing.JLabel();
        line = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Screen");
        setFocusable(false);
        setResizable(false);

        userInput.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        userInput.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userInputFocusGained(evt);
            }
        });
        userInput.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userInputKeyPressed(evt);
            }
        });

        stopwatchLabel.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        stopwatchLabel.setText("00:00.00");
        stopwatchLabel.setFocusable(false);

        currentScoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currentScoreLabel.setText("SCORE: 00000");
        currentScoreLabel.setFocusable(false);

        typeHereLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        typeHereLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        typeHereLabel.setText("TYPE HERE:");
        typeHereLabel.setToolTipText("");
        typeHereLabel.setFocusable(false);

        startCountdown.setFont(new java.awt.Font("Segoe UI", 1, 120)); // NOI18N
        startCountdown.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        startCountdown.setText(" ");
        startCountdown.setFocusable(false);

        line.setBackground(new java.awt.Color(0, 0, 0));
        line.setForeground(new java.awt.Color(0, 0, 0));
        line.setCaretColor(new java.awt.Color(0, 0, 0));
        line.setEnabled(false);
        line.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stopwatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(currentScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(typeHereLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userInput))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(startCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 330, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(line)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(healthBar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stopwatchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addComponent(startCountdown, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                .addComponent(line, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeHereLabel))
                .addGap(15, 15, 15))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userInputKeyPressed(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_userInputKeyPressed
        line.setBackground(Color.black);
        userInput.setBackground(Color.white);
        if (evt.getKeyCode() == 10) {
            
            answer = userInput.getText();
            userInput.setText("");

            if (generateLabel.checkAnswer(answer) == true) {
                Soundtrack.playCorrect();
                ColorThreadInput.isRightTrue();
                new ColorThreadInput(this).start();
                updateScore(updateNumRight());
                numRight = numRight + 1;
                generateLabel.speedUp();
                userInput.setBackground(Color.green);
                
            } else {
                ColorThreadInput.isRightFalse();
                new ColorThreadInput(this).start();
                Soundtrack.playBeep();
                numWrong = numWrong + 1;
                wordsTypedWrong.add(answer);
                userInput.setBackground(Color.red);
            }

            // Opens Game Over frame when all labels are empty - Written by Justin
            if (generateLabel.allEmptyLabels() == true) {
                endGame();
            }
        }
    }
    // GEN-LAST:event_userInputKeyPressed

    private void userInputFocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_userInputFocusGained
        if(gameFrameStatus == false) {
            randomWords = new RandomWords();
            generateLabel = new GenerateLabel(this, randomWords);
            gameThread = new GameThread(this);

            // Starts the game and GameThread when the Game Frame opens and automatically
            // gives focus to userInput - Written by Justin
            currentScoreLabel.setText("Score: ");
            stopwatchLabel.setText("00:00.00");
            healthBar.setValue(100);
            gameThread.start();
        }else {
        }
        gameFrameStatus = true;
    }// GEN-LAST:event_userInputFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentScoreLabel;
    private javax.swing.JProgressBar healthBar;
    private javax.swing.JTextField line;
    private javax.swing.JLabel startCountdown;
    private javax.swing.JLabel stopwatchLabel;
    private javax.swing.JLabel typeHereLabel;
    private javax.swing.JTextField userInput;
    // End of variables declaration//GEN-END:variables
}
