package console;

import console.answer.AverageSalaryCommand;
import console.answer.CountOfEmployeeCommand;
import console.answer.DepartmentNameCommand;
import console.answer.GlobalSearchCommand;
import console.answer.MenuCommand;
import console.answer.QuitCommand;
import console.answer.StatisticCommand;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class Application {
    private final Map<String, ConsoleHandler> operation = new HashMap<>();
    private DepartmentNameCommand departmentNameCommand;
    private StatisticCommand statisticCommand;
    private AverageSalaryCommand averageSalaryCommand;
    private CountOfEmployeeCommand countOfEmployeeCommand;
    private GlobalSearchCommand globalSearchCommand;
    private QuitCommand quitCommand;
    private MenuCommand menuCommand;

    {
        String headOfDepartment = "who is head of department";
        String statistics = "show statistics";
        String averageSalary = "show the average salary for the department";
        String countOfEmployee = "show count of employee";
        String globalSearch = "global search";
        String quit = "quit";
        String menu = "menu";
        operation.put(headOfDepartment, departmentNameCommand);
        operation.put(statistics, statisticCommand);
        operation.put(averageSalary, averageSalaryCommand);
        operation.put(countOfEmployee, countOfEmployeeCommand);
        operation.put(globalSearch, globalSearchCommand);
        operation.put(quit, quitCommand);
        operation.put(menu, menuCommand);
    }

    public Application(DepartmentNameCommand departmentNameCommand, StatisticCommand statisticCommand, AverageSalaryCommand averageSalaryCommand, CountOfEmployeeCommand countOfEmployeeCommand, GlobalSearchCommand globalSearchCommand, QuitCommand quitCommand, MenuCommand menuCommand) {
        this.departmentNameCommand = departmentNameCommand;
        this.statisticCommand = statisticCommand;
        this.averageSalaryCommand = averageSalaryCommand;
        this.countOfEmployeeCommand = countOfEmployeeCommand;
        this.globalSearchCommand = globalSearchCommand;
        this.quitCommand = quitCommand;
        this.menuCommand = menuCommand;
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
