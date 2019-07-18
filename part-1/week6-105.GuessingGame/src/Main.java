import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();

        // we play two rounds
        game.play(1,10);  // value to be guessed now within range 1-10
        game.play(10,99);  // value to be guessed now within range 10-99
    }
}
