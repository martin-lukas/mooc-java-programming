import java.util.ArrayList;

public class TheGreatest {
    public static int greatest(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            int max = list.get(0);
            for (int x : list) {
                if (x > max) {
                    max = x;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<Integer>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);
        
        System.out.println("The greatest number is: " + greatest(lista));
    }
}
