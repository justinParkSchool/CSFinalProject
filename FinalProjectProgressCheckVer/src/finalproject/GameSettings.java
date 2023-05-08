package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameSettings extends javax.swing.JFrame {

    private int numberOfLabels;
    private int startingSpeed;
    private int minusHealthAmount;
    private boolean settingsStatus = false;

    public GameSettings() {
        initComponents();
        setInitialSettings();
        numberOfWordsDisplayLabel.setText(String.valueOf(wordSlider.getValue()));
        speedDisplayLabel.setText(String.valueOf(speedSlider.getValue()));
    }

    public void setInitialSettings() {
        try {
            Scanner sc = new Scanner(new File("Settings.txt"));
            sc.nextLine();
            sc.nextLine();
            numberOfLabels = Integer.parseInt(sc.nextLine());
            startingSpeed = Integer.parseInt(sc.nextLine());
            minusHealthAmount = Integer.parseInt(sc.nextLine());
            sc.close();
        } catch (FileNotFoundException ex) {
            numberOfLabels = 5;
            startingSpeed = 30;
            minusHealthAmount = 5;
        }
        wordSlider.setValue(numberOfLabels);
        speedSlider.setValue(startingSpeed);
        healthSpinner.setValue(minusHealthAmount);
    }

    public void writeNewSettings() {
        try {
            FileWriter myWriter = new FileWriter("Settings.txt");
            myWriter.write(
                    "--Settings--\n"
                    + "[Number of Labels, Starting Speed, Minus Health Amount]\n"
                    + numberOfLabels + "\n"
                    + startingSpeed + "\n"
                    + minusHealthAmount + "\n"
            );
            myWriter.close();
            System.out.println("Written success");
        } catch (IOException ex) {
            Logger.getLogger(GameSettings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        wordSlider = new javax.swing.JSlider();
        speedSlider = new javax.swing.JSlider();
        healthSpinner = new javax.swing.JSpinner();
        okBtn = new javax.swing.JButton();
        wordsLabel = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        healthPerWordLabel = new javax.swing.JLabel();
        settingsTitleLabel = new javax.swing.JLabel();
        returnToTitle = new javax.swing.JButton();
        numberOfWordsDisplayLabel = new javax.swing.JLabel();
        speedDisplayLabel = new javax.swing.JLabel();
        easyBtn = new javax.swing.JButton();
        midBtn = new javax.swing.JButton();
        hardBtn = new javax.swing.JButton();
        randomBtm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Settings");
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        wordSlider.setMaximum(10);
        wordSlider.setMinimum(1);
        wordSlider.setFocusable(false);
        wordSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                wordSliderStateChanged(evt);
            }
        });

        speedSlider.setFocusable(false);
        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });

        healthSpinner.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        healthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 99, 1));
        healthSpinner.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                healthSpinnerFocusGained(evt);
            }
        });

        okBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        okBtn.setText("Confirm");
        okBtn.setFocusable(false);
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        wordsLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        wordsLabel.setText("Number of Words");
        wordsLabel.setFocusable(false);

        speedLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        speedLabel.setText("Speed");
        speedLabel.setFocusable(false);

        healthPerWordLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        healthPerWordLabel.setText("Health per word");
        healthPerWordLabel.setFocusable(false);

        settingsTitleLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        settingsTitleLabel.setText("Settings");
        settingsTitleLabel.setFocusable(false);

        returnToTitle.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        returnToTitle.setText("Back to Title");
        returnToTitle.setFocusable(false);
        returnToTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnToTitleActionPerformed(evt);
            }
        });

        numberOfWordsDisplayLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        numberOfWordsDisplayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numberOfWordsDisplayLabel.setText("0");

        speedDisplayLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        speedDisplayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        speedDisplayLabel.setText("0");

        easyBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        easyBtn.setText("Easy");
        easyBtn.setFocusable(false);
        easyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                easyBtnActionPerformed(evt);
            }
        });

        midBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        midBtn.setText("Medium");
        midBtn.setFocusable(false);
        midBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                midBtnActionPerformed(evt);
            }
        });

        hardBtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        hardBtn.setText("Hard");
        hardBtn.setFocusable(false);
        hardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hardBtnActionPerformed(evt);
            }
        });

        randomBtm.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        randomBtm.setText("Randomize");
        randomBtm.setFocusable(false);
        randomBtm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomBtmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(wordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(numberOfWordsDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(wordSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(speedDisplayLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(healthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(easyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(randomBtm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(okBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(midBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(returnToTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(speedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(healthPerWordLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(settingsTitleLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(settingsTitleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wordsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberOfWordsDisplayLabel)
                    .addComponent(wordSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(speedSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(speedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(speedDisplayLabel))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(healthPerWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(healthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(easyBtn)
                    .addComponent(midBtn)
                    .addComponent(hardBtn))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okBtn)
                    .addComponent(returnToTitle)
                    .addComponent(randomBtm))
                .addGap(56, 56, 56))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        TypingGame.confirmSettingsVisible();
        numberOfLabels = wordSlider.getValue();
        startingSpeed = speedSlider.getValue();
        minusHealthAmount = (int) healthSpinner.getValue();
        System.out.println(numberOfLabels);
        System.out.println(startingSpeed);
        System.out.println(minusHealthAmount);
        writeNewSettings();
    }//GEN-LAST:event_okBtnActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        if(settingsStatus == false) {
            System.out.println("reading");
            setInitialSettings();
            settingsStatus = true;
        }
    }//GEN-LAST:event_formFocusGained

    private void returnToTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnToTitleActionPerformed
        settingsStatus = false;
        TypingGame.titleFrameVisible();
    }//GEN-LAST:event_returnToTitleActionPerformed

    private void healthSpinnerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_healthSpinnerFocusGained
        if(settingsStatus == false) {
            System.out.println("reading");
            setInitialSettings();
            settingsStatus = true;
        }
    }//GEN-LAST:event_healthSpinnerFocusGained

    private void wordSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_wordSliderStateChanged
        numberOfWordsDisplayLabel.setText(String.valueOf(wordSlider.getValue()));
    }//GEN-LAST:event_wordSliderStateChanged

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        speedDisplayLabel.setText(String.valueOf(speedSlider.getValue()));
    }//GEN-LAST:event_speedSliderStateChanged

    private void easyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_easyBtnActionPerformed
        wordSlider.setValue(3);
        speedSlider.setValue(30);
        healthSpinner.setValue(5);   
    }//GEN-LAST:event_easyBtnActionPerformed

    private void midBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_midBtnActionPerformed
        wordSlider.setValue(5);
        speedSlider.setValue(50);
        healthSpinner.setValue(10);
    }//GEN-LAST:event_midBtnActionPerformed

    private void hardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hardBtnActionPerformed
        wordSlider.setValue(7);
        speedSlider.setValue(70);
        healthSpinner.setValue(15);
    }//GEN-LAST:event_hardBtnActionPerformed
  
    
    private void randomBtmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomBtmActionPerformed
      wordSlider.setValue((int)Math.floor(Math.random() * (10) + 1));
      speedSlider.setValue((int)Math.floor(Math.random() * (100) + 1));
      healthSpinner.setValue((int)Math.floor(Math.random() * (25) + 1));
       
    }//GEN-LAST:event_randomBtmActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameSettings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameSettings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton easyBtn;
    private javax.swing.JButton hardBtn;
    private javax.swing.JLabel healthPerWordLabel;
    private javax.swing.JSpinner healthSpinner;
    private javax.swing.JButton midBtn;
    private javax.swing.JLabel numberOfWordsDisplayLabel;
    private javax.swing.JButton okBtn;
    private javax.swing.JButton randomBtm;
    private javax.swing.JButton returnToTitle;
    private javax.swing.JLabel settingsTitleLabel;
    private javax.swing.JLabel speedDisplayLabel;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JSlider wordSlider;
    private javax.swing.JLabel wordsLabel;
    // End of variables declaration//GEN-END:variables
}
