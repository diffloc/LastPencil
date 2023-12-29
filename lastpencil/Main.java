package lastpencil;

public class Main {

    private static UI ui;

    public static void main(String[] args) {
        ui = new UI();
        ui.initializeGame();
        ui.startGame();
    }
}