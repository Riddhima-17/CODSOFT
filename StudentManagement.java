import java.util.*;
import java.io.*;

class Student {
    String name;
    String rollNo;
    String grade;

    // Constructor
    public Student(String name, String rollNo, String grade) {
        this.name = name;
        this.rollNo = rollNo;
        this.grade = grade;
    }

    // Convert student data to string
    public String toString() {
        return rollNo + "," + name + "," + grade;
    }

    // Print student info
    public void showDetails() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name   : " + name);
        System.out.println("Grade  : " + grade);
        System.out.println("---------------------");
    }
}

public class StudentManagement {
    static ArrayList<Student> students = new ArrayList<>();
    static String fileName = "students.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        loadData();

        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    removeStudent(sc);
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    showAllStudents();
                    break;
                case 5:
                    editStudent(sc);
                    break;
                case 6:
                    System.out.println("Exiting the program. Bye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);

        sc.close();
    }

    // Add new student
    public static void addStudent(Scanner sc) {
        System.out.print("Enter Roll Number: ");
        String roll = sc.nextLine();
        if (roll.isEmpty()) {
            System.out.println("Roll number can't be empty.");
            return;
        }

        for (Student s : students) {
            if (s.rollNo.equals(roll)) {
                System.out.println("Student already exists.");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        if (name.isEmpty()) {
            System.out.println("Name can't be empty.");
            return;
        }

        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();

        students.add(new Student(name, roll, grade));
        saveData();
        System.out.println("Student added.");
    }

    // Remove student
    public static void removeStudent(Scanner sc) {
        System.out.print("Enter Roll Number to remove: ");
        String roll = sc.nextLine();
        boolean removed = false;

        for (Student s : students) {
            if (s.rollNo.equals(roll)) {
                students.remove(s);
                removed = true;
                break;
            }
        }

        if (removed) {
            saveData();
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Search student
    public static void searchStudent(Scanner sc) {
        System.out.print("Enter Roll Number to search: ");
        String roll = sc.nextLine();
        boolean found = false;

        for (Student s : students) {
            if (s.rollNo.equals(roll)) {
                s.showDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    // Show all students
    public static void showAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.showDetails();
        }
    }

    // Edit student
    public static void editStudent(Scanner sc) {
        System.out.print("Enter Roll Number to edit: ");
        String roll = sc.nextLine();
        for (Student s : students) {
            if (s.rollNo.equals(roll)) {
                System.out.print("Enter new name: ");
                s.name = sc.nextLine();
                System.out.print("Enter new grade: ");
                s.grade = sc.nextLine();
                saveData();
                System.out.println("Student updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Save students to file
    public static void saveData() {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            for (Student s : students) {
                writer.println(s.toString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    // Load students from file
    public static void loadData() {
        students.clear();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    students.add(new Student(parts[1], parts[0], parts[2]));
                }
            }

            reader.close();
        } catch (IOException e) {
            // File may not exist yet
        }
    }
}
