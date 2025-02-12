package gransnitt;

import register.Game;
import register.Games;

import java.io.IOException;
import java.util.Scanner;

public class GameMeny {
    private Games gameRegister;
    private final Scanner inMatning;

    public GameMeny() {
        inMatning = new Scanner(System.in);
    }

    public int showMeny() {

        System.out.println("------ Meny ------\n");
        System.out.println("1.\tVisa spellistan");
        System.out.println("2.\tLägg till spel");
        System.out.println("3.\tTa bort ett spel");
        System.out.println("4.\tUppdatera info om ett spel");
        System.out.println("5.\tAvsluta\n\n");
        System.out.print("Ange siffra som motsvarar menyval: ");

        int valStr = inMatning.nextInt();

        return valStr;
    }

    public Games getGameRegister() {
        return gameRegister;
    }

    public void setGameRegister(Games gameRegister) {
        this.gameRegister = gameRegister;
    }

    public void showGames() {
        System.out.println("--- Visa spellistan ---");
        System.out.println("-----------------------");

        gameRegister.skrivUtInfo();
    }

    public void addAGame() {
        System.out.println("--- Lägg till ett spel ---");
        System.out.println("--------------------------");
        System.out.println("Ange titel: ");
        String titel = inMatning.next();
        System.out.println("Ange datum när du spelade senast: ");
        String date = inMatning.next();
        System.out.println("Ange total speltid i timmar: ");
        String time = inMatning.next();

        int gamenumber = gameRegister.findGameNumber();

        Game newGame = new Game();

        newGame.setTitel(titel);
        newGame.setLastTimePLayed(date);
        newGame.setTotalTimePlayed(Integer.parseInt(time));
        newGame.setGameNumber(gamenumber);

        gameRegister.addGame(newGame);
    }

    public void removeGame() {
        System.out.println("--- Ta bort ett spel ---");
        System.out.println("------------------------");

        System.out.println("Vilket spel vill du radera?");
        for (int i = 0; i < gameRegister.getAmountOfGames(); i++) {
            Game g = gameRegister.getGame(i);
            System.out.println((i + 1) + ". " + " " + g.getTitel());
        }

        System.out.println("Ange platsnummer för det spel du vill ta bort: ");
        int choosenGame = inMatning.nextInt() - 1;
        int amountOfGames = gameRegister.getAmountOfGames();

        if (choosenGame < amountOfGames){
            Game gameAboutToBeDeleted = gameRegister.getGame(choosenGame);
            System.out.println("Vill du radera spelet "
                    + gameAboutToBeDeleted.getTitel() + " " + "? Svara j/n");
            String val = inMatning.next().toLowerCase();
            if (val.equals("j")){
                gameRegister.removeGame(choosenGame);
                System.out.println("Spelet är raderad.");
            }else {
                System.out.println("Ingen radering utförd.");
            }
        }else {
            System.out.println("Var god att ange ett existerande spel.");
        }
    }

    public void updateGame(){
        System.out.println("--- Uppdatera info om ett spel ---");
        System.out.println("----------------------------------");

        System.out.println("Vilket spel vill du uppdatera info om?");
        for (int i = 0; i < gameRegister.getAmountOfGames(); i++) {
            Game g = gameRegister.getGame(i);
            System.out.println((i + 1) + ". " + " " + g.getTitel());
        }

        System.out.println("Ange platsnummer för det spel du vill uppdatera: ");
        int choosenGame = inMatning.nextInt() - 1;
        int amountOfGames = gameRegister.getAmountOfGames();

        if (choosenGame < amountOfGames) {
            Game gameAboutToBeUpdated = gameRegister.getGame(choosenGame);
            System.out.println("Uppdaterar info om spelet " + gameAboutToBeUpdated.getTitel());

            System.out.println("Ange nytt datum för när du spelade senast: ");
            inMatning.nextLine();
            String newLastTimePLayed = inMatning.nextLine();
            if (!newLastTimePLayed.isEmpty()) {
                gameAboutToBeUpdated.setLastTimePLayed(newLastTimePLayed);
            }

            System.out.println("Ange ny total speltid i timmar: ");
            String totalTimePlayedTest = inMatning.nextLine();
            if (!totalTimePlayedTest.isEmpty()) {
                try {
                    int newTotalTimePlayed = Integer.parseInt(totalTimePlayedTest);
                    gameAboutToBeUpdated.setTotalTimePlayed(newTotalTimePlayed);
                } catch (NumberFormatException nfe) {
                    System.out.println("Ett ogiltigt värde har skrivits in i total speltid. Vänligen skriv in ett heltal.");
                }
            }
            System.out.println("Spelets info har uppdaterats.");
        }else {
            System.out.println("Var god att ange ett existerande spel.");
        }
    }

    public void avsluta() {
        System.out.println("--- Game Over ---");
        System.out.println("-----------------");
        try {
            gameRegister.writeToFile(Properties.FILNAMN);
            System.out.println("Spelen har sparats i filen.");
        } catch (IOException ex) {
            System.out.println("Hoppsan något gick fel när filen skulle sparas i "
                    + Properties.FILNAMN);
        }
    }
}
