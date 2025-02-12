package gransnitt;

import register.Games;
import java.io.IOException;

public class GamingApp {
    public static void main(String[] args) {

        Games gameRegister = new Games();
        GameMeny meny = new GameMeny();
        meny.setGameRegister(gameRegister);

        try {
            gameRegister.readFromFile(Properties.FILNAMN);
        } catch (IOException ex) {
            System.out.println("Det uppstod problem vid läsning av filen.");
        }

        int menyVal = 0;
        while (menyVal != 5) {
            menyVal = meny.showMeny();
            switch (menyVal) {
                case 1:
                    meny.showGames();
                    break;
                case 2:
                    meny.addAGame();
                    break;
                case 3:
                    meny.removeGame();
                    break;
                case 4:
                    meny.updateGame();
                    break;
                case 5:
                    meny.avsluta();
                    break;
                default:
                    System.out.println("Ogiltigt val :( Försök igen.");

            }
        }
    }
}
