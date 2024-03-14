package school.project.Service;

import school.project.Exceptions.SchoolSystemException;
import school.project.beans.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student) throws SchoolSystemException;
    void deleteStudent(Long id) throws SchoolSystemException;
    List<Student> getAllStudents();
    Student getStudent(Long id) throws SchoolSystemException;
    List<Student> getStudentsByName(String name);


    Long getStudentAvgGrade(Long id) throws SchoolSystemException;




}
