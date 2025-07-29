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
        return switch (choice) {
            case "1" -> "addStudent";
            case "2" -> "deleteStudent";
            case "3" -> "updateStudent";
            case "4" -> "viewAllStudents";
            case "5" -> "searchStudent";
            case "6" -> "redirect:/";  // Exit back to menu
            default -> {
                model.addAttribute("error", "Invalid choice. Try again.");
                yield "home";
            }
        };
    }

    @RequestMapping("/addStudent")
    public String addStudent(@ModelAttribute("student") Student student, Model model){
            studentService.addStudent(student);
            model.addAttribute("message", "Student added successfully.");
            return "message";
    }

    @RequestMapping("/deleteStudent")
    public String deleteStudent(@RequestParam("sid") int id, Model model){
        studentService.deleteStudent(id);
        model.addAttribute("message","Successfully deleted student with ID "+ id);
        return "message";
    }



}
