package application.console.answer;

import application.console.ConsoleHandler;
import application.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.service.DepartmentService;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class CountOfEmployeeCommand implements ConsoleHandler {
    private final DepartmentService departmentService;

    @Autowired
    public CountOfEmployeeCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handleCommand() {
        System.out.println("Please specify the name of the department or print 'menu' to back to menu");
        Scanner scanner = new Scanner(System.in);
        String nameOfDepartment = scanner.nextLine();
        if (nameOfDepartment.equalsIgnoreCase("menu")) {
            return;
        }
        try {
            List<Employee> employeesOfDepartment = departmentService.findEmployeesOfDepartment(nameOfDepartment);
            System.out.println("Count of employee " + employeesOfDepartment.size());
        } catch (NoResultException e) {
            System.out.println("No departments with name " + nameOfDepartment + " was found."
                    + "Please try again.");
            handleCommand();
        }
    }
}
