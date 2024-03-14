package school.project.beans;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "students")
@Component

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)


    private Boolean isActive;
    @OneToMany(cascade = CascadeType.ALL)
    @Singular
    List<Grade> grades;


}
