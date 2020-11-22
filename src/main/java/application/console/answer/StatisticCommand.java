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
public class StatisticCommand implements ConsoleHandler {
    private DepartmentService departmentService;

    @Autowired
    public StatisticCommand(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public void handleCommand() {
        System.out.println("Please specify the name of the department or print 'menu' to back to menu.");
        Scanner scanner = new Scanner(System.in);
        String nameOfDepartment = scanner.nextLine();
        if (nameOfDepartment.equalsIgnoreCase("menu")){
            return;
        }
        try {
            List<Employee> employeesOfDepartment = departmentService.findEmployeesOfDepartment(nameOfDepartment);
            int assistants = 0;
            int associateProfessors = 0;
            int professors = 0;
            for (Employee employee : employeesOfDepartment){
                if (employee.getTitle().equals(Employee.Title.PROFESSOR)){
                    professors++;
                }
                else if (employee.getTitle().equals(Employee.Title.ASSISTANT)){
                    assistants++;
                }
                else if (employee.getTitle().equals(Employee.Title.ASSOCIATE_PROFESSOR)){
                    associateProfessors++;
                }
            }
            System.out.println("assistants " + assistants + "\n"
                    + "associate professors " + associateProfessors + "\n"
                    + "professors " + professors);
        }
        catch (NoSuchElementException e){
            System.out.println("No departments with name " + nameOfDepartment + " was found."
                    + "Please try again.");
            handleCommand();
        }
    }
}
