package lastpencil;

import java.util.Scanner;

public class UI {

    private final Scanner userInput;
    private Game game;

    public UI() {
        this.userInput = new Scanner(System.in);
    }

    public void initializeGame() {
        this.game = new Game();
        // promptForPlayers();
        staticPlayers();
        promptForPencils();
        promptForFirstPlayer();
    }

    public void promptForPlayers() {
        System.out.print("Player1 name: ");
        game.setPlayer1(userInput.nextLine());
        System.out.print("Player2 name: ");
        game.setPlayer2(userInput.nextLine());
    }

    public void staticPlayers() {
        game.setPlayer1("John");
        game.setPlayer2("Jack");
    }

    public void promptForPencils() {
        while (true) {
            System.out.println("How many pencils would you like to use:");
            try {
                int numPencils = Integer.parseInt(userInput.nextLine());
                game.setPencils(numPencils); // This will throw IllegalArgumentException if numPencils < 1
                break; // If valid, break out of the loop
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils must be an integer. Please try again.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }
    }

    public void promptForFirstPlayer() {
        while (true) {
            try {
                System.out.printf("Who will be the first (%s, %s):\n", game.getPlayer1Name(), game.getPlayer2Name());
                String firstPlayerName = userInput.nextLine();
                game.setCurrentPlayer(firstPlayerName);
                break; // If valid, break out of the loop
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage() + " - Please try again.");
            }
        }
    }

    public void startGame() {
        while (game.getRunning()) {
            game.displayPencils();
            System.out.printf("%s's turn:\n", game.getCurrentPlayer());
            // TODO: validate pencilsToTake integer (try..catch)
            game.pencilsToTake(Integer.parseInt(userInput.nextLine()));
            game.switchPlayer();
        }
    }
}
