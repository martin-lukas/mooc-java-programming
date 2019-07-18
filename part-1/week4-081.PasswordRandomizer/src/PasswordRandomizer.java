import java.util.Random;

public class PasswordRandomizer {
    private int length;
    private Random random;

    public PasswordRandomizer(int length) {
        this.length = length;
        random = new Random();
    }

    public String createPassword() {
        char[] password = new char[length];
        for (int i = 0; i <= length-1; i++) {
            int randNumber = random.nextInt(26);
            char symbol = "abcdefghijklmnopqrstuvwxyz".charAt(randNumber);
            password[i] = symbol;
        }
        return new String(password);
    }
}
