package school.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.project.Exceptions.ErrDetails;
import school.project.Exceptions.SchoolSystemException;
import school.project.Repository.StudentRepository;
import school.project.beans.Grade;
import school.project.beans.Student;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) throws SchoolSystemException {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) throws SchoolSystemException {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new SchoolSystemException(ErrDetails.STUDENT_NOT_FOUND.getMsg()));
        student.setGrades(null);
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(Long id) throws SchoolSystemException {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            throw new SchoolSystemException(ErrDetails.STUDENT_NOT_FOUND.getMsg());
        }
    }

    @Override
    public List<Student> getStudentsByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Override
    public Long getStudentAvgGrade(Long id) throws SchoolSystemException {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            List<Grade> grades = studentOptional.get().getGrades();
            double sum = grades.stream().mapToDouble(Grade::getScore).sum();
            int count = grades.size();
            double avg = sum / count;
            return Math.round(avg);
        } else {
            throw new SchoolSystemException(ErrDetails.STUDENT_NOT_FOUND.getMsg());
        }
    }
}
