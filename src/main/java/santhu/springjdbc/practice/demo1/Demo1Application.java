package santhu.springjdbc.practice.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import santhu.springjdbc.practice.demo1.model.Student;
import santhu.springjdbc.practice.demo1.service.StudentService;

import java.util.List;

@SpringBootApplication
public class Demo1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Demo1Application.class, args);
        Student student1 = context.getBean(Student.class);
        student1.setName("T K SANTHOSH RAO");
        student1.setId(100);
        student1.setMarks(26.00f);
        StudentService service = context.getBean(StudentService.class);
        service.addStudent(student1);
        List<Student> students = service.getStudents();
        System.out.println(students);
    }

}
