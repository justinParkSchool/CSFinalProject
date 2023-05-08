package finalproject;

public class GameOver extends javax.swing.JFrame {
    private GameFrame gameFrame;

    /**
     * Creates new form GameOver
     */
    public GameOver(GameFrame frame) {
        initComponents();
        gameFrame = frame;
    }
    
    //MUTATOR METHODS
    public void setTextAreaTyped(String textAreaWords) {
        wordsTypedTextArea.append(textAreaWords + "\n");
    }
    
    public void textAreaCursorUp() {
        wordsTypedTextArea.setCaretPosition(0);
    }
    
    public void setScoreLabel(String score) {
        scoreLabel.setText(score);
    }
    
    public void setTimeLabel(String time) {
        timeLabel.setText("Time: " + time);
    }

    //Resets GameOver - Written by Justin 
    public void resetGameOver() {
        scoreLabel.setText("Score: ");
        timeLabel.setText("Time: ");
        wordsTypedTextArea.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gameOverLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        wordsTypedScrollPane = new javax.swing.JScrollPane();
        wordsTypedTextArea = new javax.swing.JTextArea();
        wordsTypedLabel = new javax.swing.JLabel();
        backToMenuBtn = new javax.swing.JButton();
        addToLeaderboardBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Over");
        setResizable(false);

        gameOverLabel.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        gameOverLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gameOverLabel.setText("GAME OVER");
        gameOverLabel.setFocusable(false);

        scoreLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        scoreLabel.setText("SCORE:");
        scoreLabel.setFocusable(false);

        timeLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        timeLabel.setText("TIME:");
        timeLabel.setFocusable(false);

        wordsTypedTextArea.setColumns(20);
        wordsTypedTextArea.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        wordsTypedTextArea.setRows(5);
        wordsTypedTextArea.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        wordsTypedTextArea.setEnabled(false);
        wordsTypedTextArea.setFocusable(false);
        wordsTypedScrollPane.setViewportView(wordsTypedTextArea);

        wordsTypedLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        wordsTypedLabel.setText("WORDS TYPED:");
        wordsTypedLabel.setFocusable(false);

        backToMenuBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backToMenuBtn.setText("BACK TO MENU");
        backToMenuBtn.setFocusable(false);
        backToMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMenuBtnActionPerformed(evt);
            }
        });

        addToLeaderboardBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        addToLeaderboardBtn.setText("ADD TO LEADERBOARDS");
        addToLeaderboardBtn.setFocusable(false);
        addToLeaderboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToLeaderboardBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(gameOverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backToMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(addToLeaderboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(wordsTypedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wordsTypedScrollPane))))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(gameOverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wordsTypedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wordsTypedScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backToMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToLeaderboardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backToMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMenuBtnActionPerformed
        //Brings user back to the title - Written by Justin
        setVisible(false);
        TypingGame.titleFrameVisible();
        gameFrame.resetFileArrays();
        resetGameOver();
        Soundtrack.titleMusicOn();
    }//GEN-LAST:event_backToMenuBtnActionPerformed

    private void addToLeaderboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToLeaderboardBtnActionPerformed
        TypingGame.leaderboardVisible();
        resetGameOver();
    }//GEN-LAST:event_addToLeaderboardBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToLeaderboardBtn;
    private javax.swing.JButton backToMenuBtn;
    private javax.swing.JLabel gameOverLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JLabel wordsTypedLabel;
    private javax.swing.JScrollPane wordsTypedScrollPane;
    private javax.swing.JTextArea wordsTypedTextArea;
    // End of variables declaration//GEN-END:variables
}
