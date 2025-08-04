import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter Roll Number: ");
                    int roll = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Grade: ");
                    String grade = sc.nextLine().trim();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine().trim();
                    if (name.isEmpty() || grade.isEmpty() || email.isEmpty()) {
                        System.out.println("All fields are required.");
                    } else {
                        Student s = new Student(name, roll, grade, email);
                        sms.addStudent(s);
                    }
                    break;

                case 2:
                    System.out.print("Enter Roll Number to Edit: ");
                    int rollEdit = Integer.parseInt(sc.nextLine());
                    System.out.print("New Name: ");
                    String newName = sc.nextLine().trim();
                    System.out.print("New Grade: ");
                    String newGrade = sc.nextLine().trim();
                    System.out.print("New Email: ");
                    String newEmail = sc.nextLine().trim();
                    if (newName.isEmpty() || newGrade.isEmpty() || newEmail.isEmpty()) {
                        System.out.println("All fields are required.");
                    } else {
                        sms.editStudent(rollEdit, newName, newGrade, newEmail);
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Remove: ");
                    int rollRemove = Integer.parseInt(sc.nextLine());
                    sms.removeStudent(rollRemove);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Search: ");
                    int rollSearch = Integer.parseInt(sc.nextLine());
                    sms.searchStudent(rollSearch);
                    break;

                case 5:
                    sms.displayAllStudents();
                    break;

                case 6:
                    System.out.println("Exiting... Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice. Please choose between 1 to 6.");
            }
        }
    }
}
