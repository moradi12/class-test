package school.project.clr;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import school.project.beans.Grade;
import school.project.beans.Student;
import school.project.beans.Topic;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(1)
@RequiredArgsConstructor
public class SchoolTesting implements CommandLineRunner {
    @Autowired
    RestTemplate restTemplate;

    @Override
    public void run(String... args) throws Exception {

        try {
            Student student = Student.builder()

                    .id(1L)
                    .name("Tamir")
                    .birthday(Date.valueOf(LocalDate.of(1996, 8, 23)))
                    .isActive(true)
                    .grade(new Grade(1L, Topic.Project3, 95))
                    .grade(new Grade(2L, Topic.Project2, 100))
                    .grade(new Grade(3L, Topic.Project3, 100))
                    .build();

            Student student2 = Student.builder()

                    .id(2L)
                    .name("David")
                    .birthday(Date.valueOf(LocalDate.of(2005, 1, 23)))
                    .isActive(true)
                    .grade(new Grade(4L, Topic.Project3, 98))
                    .grade(new Grade(5L, Topic.Project2, 95))
                    .grade(new Grade(6L, Topic.Project3, 96))
                    .build();
            Student student3 = Student.builder()
                    .id(3L)
                    .name("Emma")
                    .birthday(Date.valueOf(LocalDate.of(2003, 5, 15)))
                    .isActive(true)
                    .grade(new Grade(8L, Topic.Project3, 90))
                    .grade(new Grade(9L, Topic.Project2, 85))
                    .grade(new Grade(0L, Topic.Project3, 88))
                    .build();


            restTemplate.postForEntity("http://localhost:8080/api/students", student, Student.class);
            restTemplate.postForEntity("http://localhost:8080/api/students", student2, Student.class);
            restTemplate.postForEntity("http://localhost:8080/api/students", student3, Student.class);
            System.out.println(restTemplate.getForObject("http://localhost:8080/api/students/all", String.class));
            restTemplate.delete("http://localhost:8080/api/students/{id}", 2L);
            System.out.println("Deleting student with ID 2...");
            Student[] students = restTemplate.getForObject("http://localhost:8080/api/students/all", Student[].class);



            if (students != null) {
                Arrays.stream(students).toList().forEach(System.out::println);

            }
            students = restTemplate.getForObject("http://localhost:8080/api/students/studentByName/{name}", Student[].class, "Tamir");
            if (students != null) {
                Arrays.stream(students).toList().forEach(System.out::println);
            }
            System.out.println("Average score of student with ID 1 is:" + restTemplate.getForObject("http://localhost:8080//api/students/avg/{id}", Long.class, 1L));
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
