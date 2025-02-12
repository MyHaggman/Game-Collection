package register;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Games {
    private final List<Game> games;

    public Games() {
        games = new ArrayList<>();
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(int index) {
        games.remove(index);
    }

    public Game getGame(int index) {
        return games.get(index);
    }

    public List<Game> getArrayList() {
        return games;
    }

    public void readFromFile(String fileName) throws IOException {

        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String filRad;

        while ((filRad = in.readLine()) != null) {
            String[] post = filRad.split(",");

            Game g = new Game();
            g.setGameNumber(Integer.parseInt(post[0]));
            g.setTitel(post[1]);
            g.setLastTimePLayed(post[2]);
            g.setTotalTimePlayed(Integer.parseInt(post[3]));
            this.addGame(g);
        }
        in.close();
    }

    public void writeToFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < games.size(); i++) {

            Game g = games.get(i);
            String rad = g.getGameNumber() + ","
                    + g.getTitel() + ","
                    + g.getLastTimePlayed() + ","
                    + g.getTotalTimePlayed();
            bw.write(rad);
            bw.newLine();
        }
        bw.close();
    }

    public void skrivUtInfo() {
        System.out.println("Plats\tSpelnummer\tTitel\tSenast spelad\tTotal speltid");
        for (int i = 0; i < games.size(); i++) {
            Game g = games.get(i);

            String totalTimePlayedHour = g.getTotalTimePlayed() + " timmar";

            String info = i + "\t"
                    + "\t" + g.getGameNumber() + "\t" + "\t"
                    + "\t" + g.getTitel()
                    + "\t" + g.getLastTimePlayed() + "\t"
                    + "\t" + totalTimePlayedHour;

            System.out.println(info);
        }
    }

    public int findGameNumber() {

        int newGameNumber = 0;
        for (Game g : games) {
            if (g.getGameNumber() > newGameNumber){
                newGameNumber = g.getGameNumber();
            }
        }
        return newGameNumber + 1;
    }

    public int getAmountOfGames(){
        return games.size();
    }
}
