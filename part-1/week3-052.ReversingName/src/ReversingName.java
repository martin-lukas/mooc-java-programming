import java.util.Scanner;

public class ReversingName {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
    
        System.out.print("Type your name: ");
        String name = reader.nextLine();
        
        char[] chars = name.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while (i < j) {
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i++;
            j--;
        }
        String reversed = new String(chars);
        System.out.println("In reverse order: " + reversed);
    }
}
