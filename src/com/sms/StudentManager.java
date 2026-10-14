package com.sms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    // 1. Add Student
    public boolean addStudent(Student student) {

        // Check for duplicate student ID
        for (Student s : students) {
            if (s.getId() == student.getId()) {
                System.out.println("Student ID already exists!");
                return false;
            }
        }

        students.add(student);
        System.out.println("Student added successfully!");
        return true;
    }

    // 2. Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
            System.out.println("--------------------");
        }
    }

    // 3. Search Student by ID
    public Student searchStudent(int id) {

        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    // 4. Update Student Details
    public boolean updateStudent(int id, String name, int age) {

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return false;
        }

        s.setName(name);
        s.setAge(age);

        System.out.println("Student updated successfully!");
        return true;
    }

    // 5. Delete Student
    public boolean deleteStudent(int id) {

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return false;
        }

        students.remove(s);
        System.out.println("Student deleted successfully!");
        return true;
    }

    // 6. Sort Students by ID
    public void sortById() {

        students.sort(
                Comparator.comparingInt(Student::getId)
        );

        System.out.println("Students sorted by ID.");
        displayStudents();
    }

    // 7. Add or Update Student Marks
    public boolean addOrUpdateMarks(int id, String subject, int marks) {

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return false;
        }

        if (subject == null || subject.isBlank()) {
            System.out.println("Subject cannot be empty!");
            return false;
        }

        if (marks < 0 || marks > 100) {
            System.out.println("Marks must be between 0 and 100!");
            return false;
        }

        s.addOrUpdateMarks(subject.trim(), marks);

        System.out.println("Marks saved successfully!");
        return true;
    }

    // 8. Display Student Result
    public void displayResult(int id) {

        Student s = searchStudent(id);

        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        Map<String, Integer> marksMap = s.getMarks();

        if (marksMap.isEmpty()) {
            System.out.println("No marks available for this student.");
            return;
        }

        int total = 0;
        int maxMarks = marksMap.size() * 100;

        System.out.println("\n----- STUDENT RESULT -----");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());

        for (Map.Entry<String, Integer> entry
                : marksMap.entrySet()) {

            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );

            total += entry.getValue();
        }

        double percentage = (total * 100.0) / maxMarks;

        System.out.println("Total Marks: " + total
                + "/" + maxMarks);
        System.out.printf("Percentage: %.2f%%%n", percentage);
    }

    // 9. Sort Students by Name
    public void sortByName() {

        students.sort(
                Comparator.comparing(
                        Student::getName,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        System.out.println("Students sorted by name.");
        displayStudents();
    }
}
