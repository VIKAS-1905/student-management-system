package com.sms;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student Details");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students by ID");
            System.out.println("7. Sort Students by Name");
            System.out.println("8. Add / Update Student Marks");
            System.out.println("9. Display Student Result");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {

                case 1: {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Student Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    Student student = new Student(id, name, age);
                    manager.addStudent(student);
                    break;
                }

                case 2:
                    manager.displayStudents();
                    break;

                case 3: {
                    System.out.print("Enter Student ID to search: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Student student = manager.searchStudent(id);

                    if (student != null) {
                        System.out.println("Student found:");
                        student.displayStudent();
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter Student ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    manager.updateStudent(id, name, age);
                    break;
                }

                case 5: {
                    System.out.print("Enter Student ID to delete: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    manager.deleteStudent(id);
                    break;
                }

                case 6:
                    manager.sortById();
                    break;

                case 7:
                    manager.sortByName();
                    break;

                case 8: {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Subject Name: ");
                    String subject = sc.nextLine();

                    System.out.print("Enter Marks (0-100): ");
                    int marks = sc.nextInt();
                    sc.nextLine();

                    manager.addOrUpdateMarks(id, subject, marks);
                    break;
                }

                case 9: {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    manager.displayResult(id);
                    break;
                }

                case 10:
                    System.out.println("Exiting Student Management System...");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-10.");
            }

        } while (choice != 10);

        sc.close();
    }
}
