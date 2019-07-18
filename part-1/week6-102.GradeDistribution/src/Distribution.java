import java.util.ArrayList;

public class Distribution {
    private int[] grades;
    
    public Distribution() {
        grades = new int[6];
    }
    
    public void gradeExams(ArrayList<Exam> exams) {
        for (Exam exam : exams) {
            int score = exam.score();
            if (score >= 50 && score <= 60) {
                grades[5]++;
            } else if (score >= 45 && score <= 49) {
                grades[4]++;
            } else if (score >= 40 && score <= 44) {
                grades[3]++;
            } else if (score >= 35 && score <= 39) {
                grades[2]++;
            } else if (score >= 30 && score <= 34) {
                grades[1]++;
            } else {
                grades[0]++;
            }
        }
    }
    
    private int numberOfAccepted() {
        int accepted = 0;
        for (int i = 1; i < grades.length; i++) {
            accepted += grades[i];
        }
        return accepted;
    }
    
    private int numberOfScores() {
        int scores = 0;
        for (int i = 0; i < grades.length; i++) {
            scores += grades[i];
        }
        return scores;
    }
    
    public void print() {
        System.out.println("Grade distribution:");
        for (int i = grades.length - 1; i >= 0; i--) {
            System.out.print("" + i + ": ");
            for (int j = 0; j < grades[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        double averageAcceptance = (double) numberOfAccepted() / numberOfScores() * 100;
        System.out.println("Acceptance percentage: " + averageAcceptance);
    }
}
