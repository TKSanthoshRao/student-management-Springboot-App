package santhu.springjdbc.practice.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import santhu.springjdbc.practice.demo1.model.Student;
import santhu.springjdbc.practice.demo1.repository.StudentRepo;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo studentRepo;

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        System.out.println("...........Student Service layer.........");
        studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void deleteStudent(int id) {
        studentRepo.deleteStudentFromRepo(id);
    }

    public void updateStudent(Student student) {
        studentRepo.updateStudentInRepo(student);
    }
}
