package main;

import config.AppConfig;
import model.Department;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.DepartmentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        DepartmentService departmentService = context.getBean(DepartmentService.class);

        Employee bob = new Employee();
        bob.setName("bob");
        bob.setLastName("bobinsky");
        bob.setSalary(500d);
        bob.setTitle(String.valueOf(Employee.Title.PROFESSOR));

        Department department = new Department();
        department.setName("politology");
        department.setEmployees(List.of(bob));
        department.setHeadOfDepartment(bob);
        departmentService.addData(department);

    }
}
