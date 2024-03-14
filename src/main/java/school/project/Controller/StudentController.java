package school.project.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import school.project.Exceptions.SchoolSystemException;
import school.project.Service.StudentService;
import school.project.beans.Student;

import java.util.List;

@RequestMapping("/api/students")
@RequiredArgsConstructor
@RestController

public class StudentController implements StudentService {
    @Autowired
    StudentService studentService;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) throws SchoolSystemException {
        studentService.addStudent(student);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStudent(@PathVariable Long id) throws SchoolSystemException {
        studentService.deleteStudent(id);
    }

    @Override
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    @GetMapping("/single/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Student getStudent(@PathVariable Long id) throws SchoolSystemException {
        return studentService.getStudent(id);
    }

    @Override
    @GetMapping("/studentByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @Override
    @GetMapping("/avg/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Long getStudentAvgGrade(@PathVariable Long id) throws SchoolSystemException {
        return studentService.getStudentAvgGrade(id);
    }
}
