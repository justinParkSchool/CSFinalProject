package finalproject;

public class GameThread extends Thread {

    // Game values - Written by Paul
    private GameFrame f;
    private int numright = 0;
    private int numfalse = 0;
    private int milliseconds = 0;

    // Connects Game Frame and Game Thread, used in GameFrame - Written by Paul
    public GameThread(GameFrame form) {
        f = form;
    }

    public void resetGameThread() {
        numright = 0;
        numfalse = 0;
        milliseconds = 0;
    }

    // Formats milliseconds for the stopwatch label, used in GameFrame - Written by
    // Paul
    public String formatTime() {
        int m = (milliseconds % 360000) / 6000;
        int s = (milliseconds / 100) % 60;
        int ms = milliseconds % 100;
        String mm, ss, mss;
        mm = addZero(m);
        ss = addZero(s);
        mss = addZero(ms);
        return mm + ":" + ss + ":" + mss;
    }
    

    // Adds leading zeros for formating - Written by Paul, modified by Justin
    public String addZero(int i) {
        String s;
        if (i < 10) {
            s = "0" + i;
        } else {
            s = String.valueOf(i);
        }
        return s;
    }
    

    public int checkScores() {
        if (f.getScore() > f.getRecordsScore(0)) {
            f.setRecordsScore(0, f.getScore());
            f.setRecords(0, "    ");
            return 1;
        } else if (f.getScore() > f.getRecordsScore(1)) {
            f.setRecordsScore(1, f.getScore());
            f.setRecords(1, "    ");
            return 2;
        } else if (f.getScore() > f.getRecordsScore(2)) {
            f.setRecordsScore(2, f.getScore());
            f.setRecords(2, "    ");
            return 3;
        } else if (f.getScore() > f.getRecordsScore(3)) {
            f.setRecordsScore(3, f.getScore());
            f.setRecords(3, "    ");
            return 4;
        } else if (f.getScore() > f.getRecordsScore(4)) {
            f.setRecordsScore(4, f.getScore());
            f.setRecords(4, "    ");
            return 5;
        } else if (f.getScore() > f.getRecordsScore(5)) {
            f.setRecordsScore(5, f.getScore());
            f.setRecords(5, "    ");
            return 6;
        } else if (f.getScore() > f.getRecordsScore(6)) {
            f.setRecordsScore(6, f.getScore());
            f.setRecords(6, "    ");
            return 7;
        } else if (f.getScore() > f.getRecordsScore(7)) {
            f.setRecordsScore(7, f.getScore());
            f.setRecords(7, "    ");
            return 8;
        } else if (f.getScore() > f.getRecordsScore(8)) {
            f.setRecordsScore(8, f.getScore());
            f.setRecords(8, "    ");
            return 9;
        } else if (f.getScore() > f.getRecordsScore(9)) {
            f.setRecordsScore(9, f.getScore());
            f.setRecords(9, "    ");
            return 10;
        } else {
            System.out.println("check not working");
            System.out.println(f.getScore());
            System.out.println(f.getRecordsScore(0));
            return 0;
        }
    }

    // Runs GameThread, used in GameFrame - Written by Paul, modified by Justin
    public void run() {
        f.userInputDisable();
        resetGameThread();
        Soundtrack.playCountdown();
        // For the 3, 2, 1, Start countdown when openning Game Frame - Writtin by Justin
        for (int i = 3; i > 0; i--) {
            f.updateStartCountdown(String.valueOf(i));
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {
                resetGameThread();
                System.out.println("first exception");
            }
        }
        f.updateStartCountdown("Start");
        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            resetGameThread();
            System.out.println("second exception");
        }
        f.userInputEnable();
        f.updateStartCountdown("");
        Soundtrack.playSoundtrack();
        f.startGame();
        // Stopwatch counting up - Written by Paul, modified by Justin
        while (true) {
            f.updateStopwatch(formatTime());
            f.updateHealth();
            f.changeColor();
            numright = f.updateNumRight();
            f.updateScore(numright);
            if (f.getHealth() <= 0) {
                System.out.println("health working");
                f.endGame();
                return;
            }
            try {
                Thread.sleep(10);
                milliseconds++;
            } catch (InterruptedException ex) {
                resetGameThread();
                f.userInputDisable();
                System.out.println("intended exception");
                return;
            }
        }
    }
}
