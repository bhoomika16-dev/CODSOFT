import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadFromFile();
    }

    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getRollNumber() == student.getRollNumber()) {
                System.out.println("Student with this roll number already exists!");
                return;
            }
        }
        students.add(student);
        saveToFile();
        System.out.println("Student added successfully!");
    }

    public void removeStudent(int rollNumber) {
        Iterator<Student> iterator = students.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getRollNumber() == rollNumber) {
                iterator.remove();
                found = true;
                break;
            }
        }
        if (found) {
            saveToFile();
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                System.out.println("Student Found:\n" + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    public void editStudent(int rollNumber, String newName, String newGrade, String newEmail) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNumber) {
                s.setName(newName);
                s.setGrade(newGrade);
                s.setEmail(newEmail);
                saveToFile();
                System.out.println("Student info updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (List<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            students = new ArrayList<>();
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
