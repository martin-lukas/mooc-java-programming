
import java.util.HashMap;
import java.util.Scanner;

public class Usernames {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        HashMap<String, String> users = new HashMap<String, String>();
        users.put("alex", "mightyducks");
        users.put("emily", "cat");
    
        System.out.print("Type your username: ");
        String username = reader.nextLine();
        System.out.print("Type your password: ");
        String password = reader.nextLine();
    
        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("You are now logged into the system!");
        } else {
            System.out.println("Your username or password was invalid!");
        }
    }
}
