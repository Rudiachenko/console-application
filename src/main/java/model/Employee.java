package model;

import lombok.Data;

@Data
public class Employee {
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
