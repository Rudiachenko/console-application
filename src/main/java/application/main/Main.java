package application.main;

import application.config.AppConfig;
import application.console.Application;
import application.model.Department;
import application.model.Employee;
import application.service.impl.DepartmentServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import application.service.DepartmentService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employee bob = new Employee();
        bob.setName("bob");
        bob.setLastName("bobinsky");
        bob.setSalary(500d);
        bob.setTitle(String.valueOf(Employee.Title.PROFESSOR));

        Department department = new Department();
        department.setName("politology");
        department.setEmployees(List.of(bob));
        department.setHeadOfDepartment(bob);

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        DepartmentService departmentService = context.getBean(DepartmentService.class);
        departmentService.addData(department);

        Application application = new Application(departmentService);
        application.start();
    }
}