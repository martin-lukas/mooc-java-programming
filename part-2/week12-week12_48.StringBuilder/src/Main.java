
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(build(t));
    }

    public static String build(int[] t) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n ");
        int counter = 0;
        for (int i = 0; i < t.length; i++) {
            counter++;
            sb.append(t[i]);
    
            if (i == t.length - 1) {
                sb.append("\n");
                break;
            } else {
                sb.append(", ");
            }
            if (counter == 4) {
                counter = 0;
                sb.append("\n ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
