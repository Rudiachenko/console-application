package application.main;

import application.model.Department;
import application.model.Employee;
import application.service.DepartmentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInjector {
    private final DepartmentService departmentService;

    @Autowired
    public DataInjector(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void injectData() {
        Employee bob = new Employee();
        bob.setName("Bob");
        bob.setLastName("Bobinsky");
        bob.setSalary(800d);
        bob.setTitle(String.valueOf(Employee.Title.PROFESSOR));

        Employee alice = new Employee();
        alice.setName("Alice");
        alice.setLastName("Alison");
        alice.setSalary(800d);
        alice.setTitle(String.valueOf(Employee.Title.PROFESSOR));

        Employee boris = new Employee();
        boris.setName("Boris");
        boris.setLastName("Borisov");
        boris.setSalary(700d);
        boris.setTitle(String.valueOf(Employee.Title.ASSISTANT));

        Department politology = new Department();
        politology.setName("politology");
        politology.setEmployees(List.of(bob, alice));
        politology.setHeadOfDepartment(bob);

        Department philosophy = new Department();
        philosophy.setName("philosophy");
        philosophy.setEmployees(List.of(bob, alice, boris));
        philosophy.setHeadOfDepartment(alice);

        departmentService.addData(politology);
        departmentService.addData(philosophy);
    }
}
