package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Leaderboard extends javax.swing.JFrame {

    private GameFrame gameFrame;
    private ArrayList<Integer> leaderboardScores = new ArrayList<>();
    private ArrayList<String> leaderboardNames = new ArrayList<>();
    private boolean leaderboardStatus;
    private boolean writtenName;

    public Leaderboard(GameFrame g) {
        initComponents();
        gameFrame = g;
        gameFrame.getGameThread();
    }

    public void readScores() {  //BUGGY, FIX
        try {
            Scanner sc = new Scanner(new File("Scores.txt"));
            sc.nextLine();
            for (int i = 0; i < 10; i++) {
                leaderboardScores.add(Integer.parseInt(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leaderboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void readNames() {
        try {
            Scanner sc = new Scanner(new File("LeaderboardNames.txt"));
            sc.nextLine();
            for (int i = 0; i < 10; i++) {
                leaderboardNames.add(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Leaderboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayScores() {   //BUGGY, FIX
        jTextArea1.setText("");
        for (int i = 0; i < 9; i++) {
            jTextArea1.append((i + 1) + ". " + gameFrame.getRecordsScore(i) + "   " + gameFrame.getRecords(i) + "\n");
        }
        jTextArea1.append("10. " + gameFrame.getRecordsScore(9) + "   " + gameFrame.getRecords(9));
    }

    public void displayWrittenScores() {
        jTextArea1.setText("");
        for (int i = 0; i < 9; i++) {
            jTextArea1.append((i + 1) + ". " + leaderboardScores.get(i) + "   " + leaderboardNames.get(i) + "\n");
        }
        jTextArea1.append("10. " + leaderboardScores.get(9) + "   " + leaderboardNames.get(9));
    }

    public void writeToScores() {
        try {
            FileWriter myWriter = new FileWriter("Scores.txt");
            myWriter.write(
                    "--High Scores--\n" +
                    gameFrame.getRecordsScore(0) + "\n" +
                    gameFrame.getRecordsScore(1) + "\n" +
                    gameFrame.getRecordsScore(2) + "\n" +
                    gameFrame.getRecordsScore(3) + "\n" +
                    gameFrame.getRecordsScore(4) + "\n" +
                    gameFrame.getRecordsScore(5) + "\n" +
                    gameFrame.getRecordsScore(6) + "\n" +
                    gameFrame.getRecordsScore(7) + "\n" +
                    gameFrame.getRecordsScore(8) + "\n" +
                    gameFrame.getRecordsScore(9) + "\n"
            );
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writeToLeaderboardNames() {
        String userInput = jTextField1.getText();
        String firstName = gameFrame.readLeaderboardNames().get(0);
        String secondName = gameFrame.readLeaderboardNames().get(1);
        String thirdName = gameFrame.readLeaderboardNames().get(2);
        String fourthName = gameFrame.readLeaderboardNames().get(3);
        String fifthName = gameFrame.readLeaderboardNames().get(4);
        String sixthName = gameFrame.readLeaderboardNames().get(5);
        String seventhName = gameFrame.readLeaderboardNames().get(6);
        String eighthName = gameFrame.readLeaderboardNames().get(7);
        String ninthName = gameFrame.readLeaderboardNames().get(8);
        String tenthName = gameFrame.readLeaderboardNames().get(9);
        if (gameFrame.getNewPlacement() == 1) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                userInput + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 2) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                userInput + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 3) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                userInput + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 4) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                userInput + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 5) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                userInput + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 6) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                userInput + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 7) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                userInput + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 8) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                userInput + "\n" +
                                ninthName + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 9) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                userInput + "\n" +
                                tenthName + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else if (gameFrame.getNewPlacement() == 10) {
            try {
                FileWriter myWriter = new FileWriter("LeaderboardNames.txt");
                myWriter.write(
                        "--Leaderboards Names--\n" +
                                firstName + "\n" +
                                secondName + "\n" +
                                thirdName + "\n" +
                                fourthName + "\n" +
                                fifthName + "\n" +
                                sixthName + "\n" +
                                seventhName + "\n" +
                                eighthName + "\n" +
                                ninthName + "\n" +
                                userInput + "\n");
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("newPlacement not working");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Leaderboards");
        setFocusable(false);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("LEADERBOARD");
        jLabel1.setFocusable(false);

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setEnabled(false);
        jTextArea1.setFocusable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("TITLE");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setText("QUIT");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Enter Your Name:");
        jLabel2.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1)
                                                .addGap(101, 101, 101)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 550,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1))
                                .addGap(15, 15, 15)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(84, 84, 84)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jButton2)
                                                        .addComponent(jButton1)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(jLabel1)))
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(15, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_jTextField1FocusGained
        if (leaderboardStatus == false) {
            displayScores();
            writtenName = false;
        } else {
        }
        leaderboardStatus = true;
    }// GEN-LAST:event_jTextField1FocusGained

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyReleased
        if (evt.getKeyCode() == 10) {
            writeToLeaderboardNames();
            writeToScores();
            readScores();
            readNames();
            displayWrittenScores();
            writtenName = true;
            jTextField1.setText("");
            jTextField1.setEnabled(false);
            leaderboardStatus = false;
        }
    }// GEN-LAST:event_jTextField1KeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        if (writtenName == true) {
            gameFrame.resetFileArrays();
            writtenName = false;
            jTextField1.setEnabled(true);
            leaderboardNames = new ArrayList<>();
            leaderboardScores = new ArrayList<>();
            System.exit(0);
        } else {
            jTextField1.setText("Please Enter Your Name");
        }
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (writtenName == true) {
            gameFrame.resetFileArrays();
            Soundtrack.titleMusicOn();
            TypingGame.titleFrameVisible();
            writtenName = false;
            jTextField1.setEnabled(true);
            leaderboardNames = new ArrayList<>();
            leaderboardScores = new ArrayList<>();
        } else {
            jTextField1.setText("Please Enter Your Name");
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
