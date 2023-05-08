package finalproject;

public class TypingGame {

    private static TitleFrame titleFrame = new TitleFrame();
    private static GameFrame gameFrame = new GameFrame();
    private static Leaderboard leaderboard = new Leaderboard(gameFrame);
    private static GameSettings gameSettings = new GameSettings();
    private static ConfirmSettings confirmSettings = new ConfirmSettings();

    public static void titleFrameVisible() {
        titleFrame.setVisible(true);
        gameFrame.setVisible(false);
        leaderboard.setVisible(false);
        gameSettings.setVisible(false);
    }

    public static void gameFrameVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(true);
        leaderboard.setVisible(false);
        gameSettings.setVisible(false);
    }

    public static void gameOverVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(false);
        leaderboard.setVisible(false);
        gameSettings.setVisible(false);
    }

    public static void leaderboardVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(false);
        leaderboard.setVisible(true);
        gameSettings.setVisible(false);
    }

    public static void gameSettingsVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(false);
        leaderboard.setVisible(false);
        gameSettings.setVisible(true);
    }

    public static void confirmSettingsinVisible() {
        confirmSettings.setVisible(false);

    }

    public static void confirmSettingsVisible() {
        titleFrame.setVisible(false);
        gameFrame.setVisible(false);
        leaderboard.setVisible(false);
        confirmSettings.setVisible(true);

    }

    public static void main(String[] args) {
        titleFrame.setVisible(true);
    }
}
