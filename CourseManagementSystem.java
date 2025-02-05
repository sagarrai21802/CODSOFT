package Assisgnments;

import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity, enrolled;
    
    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
        this.schedule = schedule;
    }
    
    boolean registerStudent() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }
    
    boolean dropStudent() {
        if (enrolled > 0) {
            enrolled--;
            return true;
        }
        return false;
    }
    
    int availableSlots() {
        return capacity - enrolled;
    }
    
    @Override
    public String toString() {
        return code + " - " + title + " (" + availableSlots() + " slots available)\n" + description + "\nSchedule: " + schedule;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses;
    
    Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
    
    boolean registerCourse(Course course) {
        if (course.registerStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }
    
    boolean dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            course.dropStudent();
            registeredCourses.remove(course);
            return true;
        }
        return false;
    }
    
    void listCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println(name + " is not registered for any courses.");
        } else {
            System.out.println(name + "'s registered courses:");
            for (Course c : registeredCourses) {
                System.out.println(c.code + " - " + c.title);
            }
        }
    }
}

public class CourseManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        
        // Sample Courses
        courses.add(new Course("CS101", "Intro to Programming", "Learn the basics of programming.", 3, "Mon-Wed 10 AM"));
        courses.add(new Course("MTH102", "Calculus", "Differentiation and Integration concepts.", 2, "Tue-Thu 2 PM"));
        
        while (true) {
            System.out.println("\nCourse Management System:");
            System.out.println("1. List Courses");
            System.out.println("2. Register Student");
            System.out.println("3. Register for Course");
            System.out.println("4. Drop Course");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    for (Course c : courses) System.out.println(c);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    students.add(new Student(id, name));
                    System.out.println("Student Registered!");
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    Student student = students.stream().filter(s -> s.id.equals(id)).findFirst().orElse(null);
                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter Course Code: ");
                    String code = scanner.nextLine();
                    Course course = courses.stream().filter(c -> c.code.equals(code)).findFirst().orElse(null);
                    if (course != null && student.registerCourse(course)) {
                        System.out.println("Successfully registered for " + course.title);
                    } else {
                        System.out.println("Course full or invalid course code!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    id = scanner.nextLine();
                    student = students.stream().filter(s -> s.id.equals(id)).findFirst().orElse(null);
                    if (student == null) {
                        System.out.println("Student not found!");
                        break;
                    }
                    System.out.print("Enter Course Code to Drop: ");
                    code = scanner.nextLine();
                    course = courses.stream().filter(c -> c.code.equals(code)).findFirst().orElse(null);
                    if (course != null && student.dropCourse(course)) {
                        System.out.println("Successfully dropped " + course.title);
                    } else {
                        System.out.println("Invalid course code or not registered!");
                    }
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
}
