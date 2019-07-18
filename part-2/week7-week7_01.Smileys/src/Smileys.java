
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
         printWithSmileys("Method");
         printWithSmileys("Beerbottle");
         printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        String smiley = ":)";
        String midString;
        if (characterString.length() % 2 != 0) {
            midString = smiley + " " + characterString + "  " + smiley;
        } else {
            midString = smiley + " " + characterString + " " + smiley;
        }
        String border = "";
        for (int i = 0; i < midString.length() / 2; i++) {
            border += smiley;
        }
        System.out.println(border);
        System.out.println(midString);
        System.out.println(border);
    }

}
