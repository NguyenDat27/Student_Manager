package success.thanhdat.web.managerstudent.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import success.thanhdat.web.managerstudent.model.Student;
import org.springframework.http.HttpStatus;
import success.thanhdat.web.managerstudent.repository.StudentRepository;
import success.thanhdat.web.managerstudent.exception.ResourceNotFoundException;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @Override
    public ResponseEntity<Student> getStudentById(int id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));
        return ResponseEntity.ok(student);
    }

    @Override
    public ResponseEntity<Student> updateStudent(int id, Student studentdetails){
        Student updateStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        updateStudent.setFirst_name(studentdetails.getFirst_name());
        updateStudent.setLast_name(studentdetails.getLast_name());
        updateStudent.setPhone(studentdetails.getPhone());
        updateStudent.setAddress(studentdetails.getAddress());

        studentRepository.save(updateStudent);

        return ResponseEntity.ok(updateStudent);
    }
    @Override
    public ResponseEntity<Student> deleteStudent(int id){
        Student deleteStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not exist with id:" + id));

        studentRepository.delete(deleteStudent);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
