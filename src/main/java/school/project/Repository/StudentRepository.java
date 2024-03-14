package school.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.project.beans.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
List<Student>findStudentByName(String name);


}
