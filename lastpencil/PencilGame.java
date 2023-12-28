package lastpencil;

import java.util.Scanner;

public class PencilGame {

    public void startGame() {
        Scanner userInput = new Scanner(System.in);

        // Number of pencils input with validation
        System.out.println("How many pencils would you like to use:");
        int numPencils;
        try {
            numPencils = Integer.parseInt(userInput.nextLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number of pencils must be an integer.");
        }

        // First player input with static name validation
        System.out.println("Who will be the first (John, Jack):");
        String firstPlayer = userInput.nextLine();
        if (!firstPlayer.equals("John") && !firstPlayer.equals("Jack")) {
            throw new IllegalArgumentException("Invalid first player name.");
        }

        System.out.println(drawPencils(numPencils));
        System.out.printf("%s is going first!\n", firstPlayer);
    }

    private String drawPencils(int numPencils) {
        StringBuilder pencils = new StringBuilder();

        for (int i = 0; i < numPencils; i++) {
            pencils.append('|');
        }
        return pencils.toString();
    }
}
