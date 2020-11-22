package application.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String title;
    private Double salary;

    public enum Title {
        ASSISTANT,
        ASSOCIATE_PROFESSOR,
        PROFESSOR
    }
}
