


import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("=== Student Grade Management System ===");
        
        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) break;

            System.out.print("Enter score for " + name + ": ");
            double score = Double.parseDouble(scanner.nextLine());

            students.add(new Student(name, score));
        }

        if (students.isEmpty()) {
            System.out.println("No data entered.");
            return;
        }

        // Calculations
        double total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {
            total += s.score;
            if (s.score > highest.score) highest = s;
            if (s.score < lowest.score) lowest = s;
        }

        double average = total / students.size();

        // Summary Report
        System.out.println("\n--- Summary Report ---");
        System.out.printf("Total Students: %d\n", students.size());
        System.out.printf("Average Score:  %.2f\n", average);
        System.out.printf("Highest Score:  %.2f (%s)\n", highest.score, highest.name);
        System.out.printf("Lowest Score:   %.2f (%s)\n", lowest.score, lowest.name);
        System.out.println("----------------------");
    }
}


class Student {
    String name;
    double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
}


