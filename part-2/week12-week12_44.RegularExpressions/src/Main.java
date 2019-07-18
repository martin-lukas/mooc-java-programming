
public class Main {

    public static void main(String[] args) {
        clockTime("45:98:47");
    }
    
    public static boolean isAWeekDay(String string) {
        if (string.matches("(mon|tue|wed|thu|fri|sat|sun)")) {
            return true;
        }
        return false;
    }
    
    public static boolean allVowels(String string) {
        if (string.matches("[aeiouäö]*")) {
            return true;
        }
        return false;
    }
    
    public static boolean clockTime(String string) {
        if (string.matches("\\d\\d:\\d\\d:\\d\\d")) {
            String hours = string.substring(0, 2);
            String minutes = string.substring(3, 5);
            String seconds = string.substring(6, 8);
            if (hours.matches("(0\\d|1\\d|2[0-3])")
                    && minutes.matches("(0\\d|[0-5]\\d)")
                    && seconds.matches("(0\\d|[0-5]\\d)")) {
                return true;
            }
        }
        return false;
    }
}
