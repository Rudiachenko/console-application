package application.console.answer;

import application.console.ConsoleHandler;
import application.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.service.DepartmentService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class AverageSalaryCommand implements ConsoleHandler {
    private DepartmentService departmentService;

    @Autowired
    public AverageSalaryCommand(DepartmentService departmentService) {
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
            double salary = 0;
            for (Employee employee : employeesOfDepartment) {
                salary = salary + employee.getSalary();
            }
            double averageSalary = salary / employeesOfDepartment.size();
            System.out.println("The average salary of " + nameOfDepartment + " " + averageSalary);
        } catch (NoSuchElementException e) {
            System.out.println("No departments with name " + nameOfDepartment + " was found."
                    + "Please try again.");
            handleCommand();
        }
    }
}
