import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

        // Input validation
        while (subjectCount <= 0) {
            System.out.print("Number of subjects must be positive. Please enter again: ");
            subjectCount = scanner.nextInt();
        }

        int[] marks = new int[subjectCount];
        int total = 0;

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            int mark = scanner.nextInt();

            // Validate input range
            while (mark < 0 || mark > 100) {
                System.out.print("Invalid input. Marks must be between 0 and 100. Re-enter: ");
                mark = scanner.nextInt();
            }

            marks[i] = mark;
            total += mark;
        }

        double average = (double) total / subjectCount;
        char grade;

        // Grade calculation logic
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n----- Result -----");
        System.out.println("Total Marks     : " + total + " out of " + (subjectCount * 100));
        System.out.printf("Average Percentage : %.2f%%\n", average);
        System.out.println("Grade           : " + grade);

        scanner.close();
    }
}
