package santhu.springjdbc.practice.demo1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import santhu.springjdbc.practice.demo1.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {


}