package register;

public class Game {
    private int gameNumber;
    private String titel;
    private String lastTimePLayed;
    private int totalTimePlayed;

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getLastTimePlayed() {
        return lastTimePLayed;
    }

    public void setLastTimePLayed(String lastTimePLayed) {
        this.lastTimePLayed = lastTimePLayed;
    }

    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }

    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }
}
