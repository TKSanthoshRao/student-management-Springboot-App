package santhu.springjdbc.practice.demo1.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import santhu.springjdbc.practice.demo1.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Student student) {
        String sql = "insert into student(name,marks,gender) values(?,?,?)";
        jdbcTemplate.update(sql, student.getName(),student.getMarks(),student.getGender());
        System.out.println("****** Saved into student repo successfully ********");

    }

    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setMarks(rs.getFloat("marks"));
            student.setGender(rs.getString("gender").charAt(0));
            return student;
        });
    }
    public void updateStudentInRepo(Student student) {
        String sql = "UPDATE student SET name = ?, marks = ?, gender = ? WHERE id = ?";
        jdbcTemplate.update(sql,student.getName(),student.getMarks(),student.getGender(),student.getId());

    }

    public void deleteStudentFromRepo(int id) {
        try {
            int rows = jdbcTemplate.update("DELETE FROM student WHERE id = ?", id);
            if (rows > 0) {
                System.out.println("✅ Student with ID " + id + " deleted successfully.");
            } else {
                System.out.println("⚠️ No student found with ID " + id + ".");
            }
        } catch (DataAccessException ex) {
            System.out.println("❌ Database error while deleting student: " + ex.getMessage());
        }
    }

}
