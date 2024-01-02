package lastpencil;

public class Game {
    private Boolean running;
    private final Players[] players;
    private Players currentPlayer;
    private Pencils pencils;

    public Game() {
        this.running = true;
        this.players = new Players[2];
    }

    public void setRunning(Boolean isRunning) {
        this.running = isRunning;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setPlayer1(String name) {
        this.players[0] = new Players(name);
    }

    public void setPlayer2(String name) {
        this.players[1] = new Players(name);
    }

    public String getPlayer1Name () {
        return players[0].getPlayerName();
    }

    public String getCurrentPlayer() {
        return currentPlayer.getPlayerName();
    }

    public String getPlayer2Name () {
        return players[1].getPlayerName();
    }

    public void setCurrentPlayer(String firstPlayerName) {
        if (firstPlayerName.equals(players[0].getPlayerName())) {
            this.currentPlayer = players[0];
        } else if (firstPlayerName.equals(players[1].getPlayerName())) {
            this.currentPlayer = players[1];
        } else {
            throw new IllegalArgumentException("Invalid player name");
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == players[0]) ? players[1] : players[0];
    }

    public void setPencils(int numPencils) {
        this.pencils = new Pencils(numPencils);
    }

    public void displayPencils() {
        System.out.println(pencils.drawPencils());
    }

    public void pencilsToTake(int numPencils) {
        if (numPencils < 1 || numPencils > 3) {
            throw new IllegalArgumentException("Possible values: '1', '2' or '3'");
        }
        if (numPencils > pencils.getNumPencils()) {
            throw new IllegalArgumentException("Too many pencils were taken");
        }
        pencils.takePencils(numPencils);

        if (pencils.getNumPencils() == 0) {
            switchPlayer();
            System.out.printf("%s won!", getCurrentPlayer());
            this.running = false;
        }
    }

    public void validatePencils(int numPencils) {
        if (numPencils < 1 || numPencils > 3) {
            throw new IllegalArgumentException("Possible values: '1', '2' or '3'");
        }
        if (numPencils > pencils.getNumPencils()) {
            throw new IllegalArgumentException("Too many pencils were taken");
        }
    }
}
