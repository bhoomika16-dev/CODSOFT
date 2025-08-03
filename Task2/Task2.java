import java.util.*;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Subjects");
        int n = scanner.nextInt();
        int[] marks = new int[n];
        int total = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Subject " + (i + 1) + ":");
            marks[i] = scanner.nextInt();
            total += marks[i];
        }
        double average = (double) total / n;
        System.out.println("\n-------------Grading Summary ---------------");
     System.out.println("\nTotal Marks: " + total +" | Average percentage: " + average+"%"+   " | Grade: " + (average >= 90 ? "A" : average >= 80 ? "B" : average >= 70 ? "C" : average >= 60 ? "D" : "F"));
        System.out.println("\n--- Thank you for using the grading system! ---");

        scanner.close();
    }
}