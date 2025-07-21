package santhu.springjdbc.practice.demo1;

import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import santhu.springjdbc.practice.demo1.model.Student;
import santhu.springjdbc.practice.demo1.service.StudentService;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ApplicationContext context = SpringApplication.run(Demo1Application.class, args);
        StudentService service = context.getBean(StudentService.class);

        boolean running = true;
        System.out.println("🎓 Welcome to Student Management System");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. View All Students");
            System.out.println("5. View Student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-6): ");

            int choice = getIntInput(sc);

            running = switch (choice) {
                case 1 -> {
                    Student student = context.getBean(Student.class);
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Marks: ");
                    double marks = getDoubleInput(sc);
                    System.out.print("Enter Gender: ");
                    char gender = sc.next().charAt(0);

                    student.setMarks((float)marks);
                    student.setName(name);
                    student.setGender(gender);

                    service.addStudent(student);
                    System.out.println("✅ Student added successfully.");
                    yield true;
                }
                case 2 -> {
                    System.out.print("Enter Id of Student: ");
                    int id = sc.nextInt();
                    service.deleteStudent(id);
                    yield true;
                }
                case 3 -> {
                      System.out.print("Enter Student ID to update: ");
                       int id = getIntInput(sc);
                    List<Student> students = service.getStudents();
                    Student updatable = null;
                    for(Student student : students) if(student.getId() == id){
                        updatable = student;
                        break;
                    }
                    if(updatable!=null) {
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Marks: ");
                        double marks = getDoubleInput(sc);
                        System.out.print("Enter Gender: ");
                        char gender = sc.next().charAt(0);
                        updatable.setName(name);
                        updatable.setMarks((float)marks);
                        updatable.setGender(gender);
                        service.updateStudent(updatable);
                        System.out.println("Updated data Sucessfully");
                    }else{
                        System.out.println("No Student found with the given ID");
                    }
                    yield true;
                }
                case 4 -> {

                    List<Student> students = service.getStudents();
                    if (students.isEmpty()) {
                        System.out.println("📭 No student records found.");
                    } else {
                        System.out.println("\n📋 Student List:");
                        students.forEach(s -> System.out.println("ID: " + s.getId() + ", Name: " + s.getName() + ", Marks: " + s.getMarks()+", Gender: " + s.getGender()));
                    }
                    yield true;
                }
                case 5 -> {
                    System.out.println("👋 Exiting... Thank you!");
                    yield false;
                }
                default -> {
                    System.out.println("❌ Invalid choice. Please try again.");
                    yield true;
                }
            };
        }
    }

    private static int getIntInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine();
        return value;
    }

    // Helper for safe double input
    private static double getDoubleInput(Scanner sc) {
        while (!sc.hasNextDouble()) {
            System.out.print("Please enter a valid decimal number: ");
            sc.next();
        }
        double value = sc.nextDouble();
        sc.nextLine();
        return value;
    }

}
