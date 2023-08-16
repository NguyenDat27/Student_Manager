package success.thanhdat.web.managerstudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import success.thanhdat.web.managerstudent.model.Student;
import success.thanhdat.web.managerstudent.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public String add(@RequestBody Student student){
        studentService.saveStudent(student);
        return "New student is added";
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById (@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent (@PathVariable int id, @RequestBody Student studentdetails){
        return studentService.updateStudent(id, studentdetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        return studentService.deleteStudent(id);
    }

}
