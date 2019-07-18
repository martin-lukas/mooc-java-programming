import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    
        ArrayList<Exam> exams = new ArrayList<Exam>();
    
        System.out.println("Type exam scores, -1 completes:");
        while (true) {
            int score = scan.nextInt();
            if (score == -1) {
                break;
            }
            if (score >= 0 && score <= 60) {
                exams.add(new Exam(score));
            }
        }
        
        Distribution dist = new Distribution();
        dist.gradeExams(exams);
        dist.print();
    }
}
