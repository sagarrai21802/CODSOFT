package Assisgnments;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numSubjects = 5;//scanner.nextInt();
        
        int totalMarks = 0;
        String arr[] = {"Maths","BEEE","OOPS","Software Engineering","Toc"};
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter marks obtained in subject " + arr[i] + " (out of 100): ");
            int marks = scanner.nextInt();
            
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid input! Enter marks between 0 and 100: ");
                marks = scanner.nextInt();
            }
            
            totalMarks += marks;
        }
        
        double averagePercentage = (double) totalMarks / numSubjects;
        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        
     scanner.close();
    }
}
