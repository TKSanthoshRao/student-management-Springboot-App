package santhu.springjdbc.practice.demo1.Controller;
import santhu.springjdbc.practice.demo1.model.Student;

import santhu.springjdbc.practice.demo1.service.StudentService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
public class HomeController{

    StudentService studentService;


    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/handleChoice")
    public String choice(@RequestParam("choice") String choice, Model model){
         switch (choice) {
             case "1" :
                 return "addStudent";
//             case "2" :
//                 return "deleteStudent";
//             case "3" :
//                 return "updateStudent";
             case "4" :
                 return "redirect:/viewAllStudents";
             case "5" :
                 return "searchStudent";
             default :
                model.addAttribute("error", "Invalid choice. Try again.");
                return "home";
        }
    }

    @RequestMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student, Model model){
            studentService.addStudent(student);
            model.addAttribute("message", "Student added successfully.");
            return "message";
    }

//    @RequestMapping("/deleteStudent")
//    public String deleteStudent(@RequestParam("sid") int id, Model model){
//        studentService.deleteStudent(id);
//        model.addAttribute("message","Successfully deleted student with ID "+ id);
//        return "message";
//    }

//    @RequestMapping("/updateStudent")
//    public String updateStudent(Student student,Model model){
//        studentService.updateStudent(student);
//        model.addAttribute("message","Successfully Updated student details");
//        return "message";
//    }

    @RequestMapping("/viewAllStudents")
    public String viewAllStudents(Model model){
    List<Student> students = studentService.getStudents();
    model.addAttribute("students",students);
        return "viewAllStudents";
    }

//    @RequestMapping("/searchStudent")
//    public String searchStudent(@RequestParam("pattern") String pattern, Model model){
//        List<Student> students = studentService.search(pattern);
//        model.addAttribute("students",students);
//        return "ShowSearchedStudent";
//    }
}
