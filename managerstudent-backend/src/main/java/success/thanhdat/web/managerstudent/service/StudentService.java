package success.thanhdat.web.managerstudent.service;

import org.springframework.http.ResponseEntity;
import success.thanhdat.web.managerstudent.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public ResponseEntity<Student> getStudentById(int id);
    public ResponseEntity<Student> updateStudent(int id, Student studentdetails);
    public ResponseEntity<Student> deleteStudent(int id);
}
