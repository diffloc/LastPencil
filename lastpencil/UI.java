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
        System.out.println("How many pencils would you like to use:");
        while (true) {

            try {
                int numPencils = Integer.parseInt(userInput.nextLine());
                game.setPencils(numPencils);
                break;
            } catch (NumberFormatException e) {
                System.out.println("The number of pencils should be numeric");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void promptForFirstPlayer() {
        System.out.printf("Who will be the first (%s, %s):\n", game.getPlayer1Name(), game.getPlayer2Name());
        while (true) {
            try {

                String firstPlayerName = userInput.nextLine();
                game.setCurrentPlayer(firstPlayerName);
                break; // If valid, break out of the loop
            } catch (IllegalArgumentException e) {
                System.out.printf("Choose between '%s' and '%s'\n", game.getPlayer1Name(), game.getPlayer2Name());
            }
        }
    }

    public void startGame() {
        while (game.getRunning()) {
            game.displayPencils();
            System.out.printf("%s's turn!\n", game.getCurrentPlayer());


            while (true) {
                try {
                    game.pencilsToTake(Integer.parseInt(userInput.nextLine()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Possible values: '1', '2' or '3'");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            game.switchPlayer();
        }
    }
}
