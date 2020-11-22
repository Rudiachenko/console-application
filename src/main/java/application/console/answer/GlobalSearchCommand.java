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
public class GlobalSearchCommand implements ConsoleHandler {
    private final DepartmentService departmentService;

    @Autowired
    public GlobalSearchCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handleCommand() {
        System.out.println("Please specify template or print 'menu' to back to menu");
        Scanner scanner = new Scanner(System.in);
        String template = scanner.nextLine();
        if (template.equalsIgnoreCase("menu")) {
            return;
        }
        try {
            List<Employee> employeesOfDepartment = departmentService.findEmployeesOfDepartment(template);
            StringBuilder answer = new StringBuilder(", ");
            for (Employee employee : employeesOfDepartment){
                String name = employee.getName();
                String lastName = employee.getLastName();
                String fullName = name + " " + lastName;
                if (fullName.contains(template)){
                    answer.append(fullName);
                }
            }
            System.out.println(answer);
        } catch (NoResultException e) {
            System.out.println("No departments with name " + template + " was found."
                    + "Please try again.");
            handleCommand();
        }
    }
}
