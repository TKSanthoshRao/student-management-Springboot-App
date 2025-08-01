package santhu.springjdbc.practice.demo1.service;

import java.util.Optional;
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
        studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public void deleteStudent(int id) {
        Optional<Student> op = studentRepo.findById(id);
        if (op.isPresent()) {
            studentRepo.delete(op.get());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

//    public Student search(String name) {
//        Optional<Student> op = studentRepo.findbyId(name);
//        return op.orElse(new Student());
//    }
}
