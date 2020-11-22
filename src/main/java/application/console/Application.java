package application.console;

import application.console.answer.AverageSalaryCommand;
import application.console.answer.CountOfEmployeeCommand;
import application.console.answer.DepartmentNameCommand;
import application.console.answer.GlobalSearchCommand;
import application.console.answer.MenuCommand;
import application.console.answer.QuitCommand;
import application.console.answer.StatisticCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.service.DepartmentService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Application {
    private DepartmentService departmentService;
    private final Map<String, ConsoleHandler> operation = new HashMap<>();

    @Autowired
    public Application(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    {
        String headOfDepartment = "who is head of department";
        String statistics = "show statistics";
        String averageSalary = "show the average salary for the department";
        String countOfEmployee = "show count of employee";
        String globalSearch = "global search";
        String quit = "quit";
        String menu = "menu";
        operation.put(headOfDepartment, new DepartmentNameCommand(departmentService));
        operation.put(statistics, new StatisticCommand(departmentService));
        operation.put(averageSalary, new AverageSalaryCommand(departmentService));
        operation.put(countOfEmployee, new CountOfEmployeeCommand(departmentService));
        operation.put(globalSearch, new GlobalSearchCommand(departmentService));
        operation.put(quit, new QuitCommand());
        operation.put(menu, new MenuCommand(departmentService));
    }


    public void start() {
        new Menu().showMenu();
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        handleCommand(command);
    }

    public void handleCommand(String command) {
        command = command.toLowerCase();
        while (true) {
            if (!operation.containsKey(command)) {
                System.out.println("Print correct data please or print 'quit' to quit");
                start();
            } else if (operation.containsKey(command)) {
                operation.get(command).handleCommand();
                command = "menu";
            }
        }
    }
}
