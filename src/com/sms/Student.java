package com.sms;
import java.util.HashMap;
import java.util.Map;

class Student {

    private int id;
    private String name;
    private int age;
    private Map<String, Integer> marks;

    // Constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = new HashMap<>();
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Add or update marks for a subject
    public void addOrUpdateMarks(String subject, int marks) {
        this.marks.put(subject, marks);
    }

    // Display student details
    public void displayStudent() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
